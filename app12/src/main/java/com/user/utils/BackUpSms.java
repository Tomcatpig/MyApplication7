package com.user.utils;

import android.content.Context;
import android.os.Environment;
import android.util.Xml;

import com.example.pojo.Message;

import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * @创建者 tw
 * @创建时间 2019/11/1
 * @描述
 */
public class BackUpSms {
    public static  void backUpSms(List<Message> messages, Context context){

try{
    XmlSerializer serializer = Xml.newSerializer();

    File file = new File( Environment.getExternalStorageDirectory(),"sms.xml");

    FileOutputStream outputStream = new FileOutputStream(file);

    serializer.setOutput(outputStream,"utf-8");
    serializer.startDocument("utf-8",true);
    serializer.startTag(null,"smss");
    for (Message message:messages){
        serializer.startTag(null,"sms");
        serializer.attribute(null,"id",message.getId()+"");

        serializer.startTag(null,"address");
        serializer.text(message.getAddress()+"");
        serializer.endTag(null,"address");

        serializer.startTag(null,"body");
        serializer.text(message.getBody()+"");
        serializer.endTag(null,"body");

        serializer.startTag(null,"date");
        serializer.text(message.getDate()+"");
        serializer.endTag(null,"date");

        serializer.startTag(null,"type");
        serializer.text(message.getType()+"");
        serializer.endTag(null,"type");

        serializer.endTag(null,"sms");


    }
    serializer.endTag(null,"smss");
    serializer.endDocument();
    outputStream.close();
    ToastShow.shortToast(context,"备份成功");

}catch (Exception e){
    ToastShow.shortToast(context,"备份失败");
    e.printStackTrace();
}
    }

    public static List<Info>readXml(Context context){


        return null;
    }
}
