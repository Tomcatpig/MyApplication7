package com.example.connect.com.example.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.util.Log;

import com.example.connect.com.example.pojo.UserLink;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @创建者 tw
 * @创建时间 2019/12/25
 * @描述 内容提供者 获取联系人信息
 */
public class ProviderLink {
    public ProviderLink(Context mContext) {
        this.mContext = mContext;
    }

    private Context mContext;

    public List<UserLink> getUserLink() {
        List<UserLink> userLinkList = new ArrayList<>();

        //得到内存分析者
        ContentResolver contentResolver = mContext.getContentResolver();
        //用查询的方法里面几个参数一定不要写错
        //先查询RawContacts.CONTENT_URI表拿到联系人id
        Cursor query = contentResolver.query(ContactsContract.RawContacts.CONTENT_URI, new String[]{ContactsContract.RawContacts._ID}, null, null, null);
        //然后拿着联系人id去data表查询属于该联系人的信息
        while (query.moveToNext()) {
            long id = query.getLong(0);
            HashMap<String, String> item = new HashMap();
            Cursor cursor2 = contentResolver.query(ContactsContract.Data.CONTENT_URI,
                    new String[]{ContactsContract.Data.DATA1, ContactsContract.Data.MIMETYPE},
                    ContactsContract.Data.RAW_CONTACT_ID + "=?",
                    new String[]{id + ""},
                    null);
            //得到data字段的值，就是联系人的信息，通过type判断是什么类型的信息
            UserLink userLink = new UserLink();
            List<String> number = new ArrayList<>();
            while (cursor2.moveToNext()) {

                String type = cursor2.getString(1);
                String data = cursor2.getString(0);
                //联系人姓名
                if (ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE.equals(type)) {
                    userLink.setUserName(data);
                 //   Log.e("name", data);
                    item.put("name", data);
                }
                //联系人电话
                else if (ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE.equals(type)) {
                    number.add(data);
                 //   Log.e("number", data);
                    item.put("phone", data);
                }

            }
            if (userLink.getUserName()==null){
                userLink.setUserName(number.get(0));
            }
            userLink.setUserNumber(number);
            userLinkList.add(userLink);
          //  Log.e("/////", "/////////////////////");

        }
       // Log.e("size", userLinkList.size() + "联系人个数");
        return userLinkList;
    }
}
