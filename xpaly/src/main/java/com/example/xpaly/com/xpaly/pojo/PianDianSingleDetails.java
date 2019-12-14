package com.example.xpaly.com.xpaly.pojo;

import com.google.gson.Gson;

import java.util.List;

/**
 * @创建者 tw
 * @创建时间 2019/12/12
 * @描述 片单 ：单个片单的内容
 */
public class PianDianSingleDetails {

    /**
     * code : 0
     * data : {"info":{"created_on":1572591646307425500,"id":"5dcc664394b02600010401a4","name":"赛博朋克风科幻电影","description":"真·赛博朋克风格科幻电影盘点","uid":"696005791","is_original":0,"pointer_id":"5dbbd81e94b0260001028352","is_default":0,"cover_url1":"http://pc.wangpan.xycdn.n0808.com/5ea4803e0f6cac7a4731f240fb44e940.jpg","cover_url2":"http://pc.wangpan.xycdn.n0808.com/d2de9168049341c2eb0971e8317034cd.jpg","cover_url3":"http://pc.wangpan.xycdn.n0808.com/62fd2503d304e99e6f71f7dfe4691b14.jpg","num":17,"num_upvote":0,"num_fav":2,"status":0,"name_check":2,"desc_check":2,"updated_on":1572591672472488400,"modified_on":1572591807019542300,"deleted_on":0,"fav_status":false,"vote_status":false,"user_name":"热心市民","user_avatar":"https://xfile2.a.88cdn.com/file/k/FkEmbOVyEZuUEB4S0NF2iAR2cFOb/300x300"},"list":[{"id":"5dbbd81e4df7f1000101fb50","movie_id":50024,"created_on":1572591806981514800,"name":"攻壳机动队","directors":"鲁伯特·桑德斯","actors":"斯嘉丽·约翰逊,皮鲁·埃斯贝克,北野武,朱丽叶·比诺什,迈克尔·皮特,黄经汉,丹妮西娅·萨马尔,拉札勒斯·雷图勒,泉原豊,托万达·马尼莫,彼得·费迪南多,安娜玛丽亚·玛琳卡,丹尼尔·亨绍尔,安德鲁·斯特林,桃井薰,查尔斯·欧比,福岛莉拉,约瑟夫·纳瓦胡,迈克尔·维克特","categories":"动作,科幻,犯罪","release_time":"2017-04-07","areas":"美国","vertical_cover_url":"http://pc.wangpan.xycdn.n0808.com/5ea4803e0f6cac7a4731f240fb44e940.jpg","popcorn_index":0.73333335},{"id":"5dbbd81e4df7f1000101fb5e","movie_id":2412,"created_on":1572591646457417500,"name":"纽约大逃亡","directors":"约翰·卡朋特","actors":"库尔特·拉塞尔,李·范·克里夫,欧内斯特·博格宁,唐纳德·普利森斯,艾萨克·海耶斯","categories":"动作,科幻,冒险","release_time":"1981-05-23","areas":"英国,美国","vertical_cover_url":"http://pc.wangpan.xycdn.n0808.com/d2de9168049341c2eb0971e8317034cd.jpg","popcorn_index":0.77272725},{"id":"5dbbd81e4df7f1000101fb5d","movie_id":57,"created_on":1572591646455081000,"name":"银翼杀手","directors":"雷德利·斯科特","actors":"哈里森·福特,鲁特格尔·哈尔,肖恩·杨,爱德华·詹姆斯·奥莫斯,M·埃梅特·沃尔什,达丽尔·汉纳,威廉·桑德森,布里翁·詹姆斯,乔·托克尔,乔安娜·卡西迪,吴汉章,摩根·保罗,凯文·汤普森","categories":"科幻,惊悚","release_time":"1982-06-25","areas":"美国,香港","vertical_cover_url":"http://pc.wangpan.xycdn.n0808.com/62fd2503d304e99e6f71f7dfe4691b14.jpg","popcorn_index":0.81672025},{"id":"5dbbd81e4df7f1000101fb5b","movie_id":3915,"created_on":1572591646455054000,"name":"机器战警2","directors":"厄文·克什纳","actors":"彼得·威勒,南茜·艾伦,加布里埃尔·达蒙,莉扎·吉邦斯","categories":"动作,科幻,惊悚,犯罪","release_time":"1990-06-22","areas":"美国","vertical_cover_url":"http://pc.wangpan.xycdn.n0808.com/82b2ef5156735f8dc9096988de9f72cf.jpg","popcorn_index":0.7619048},{"id":"5dbbd81e4df7f1000101fb5c","movie_id":61025,"created_on":1572591646455048000,"name":"人造人009","directors":"川越淳","actors":"櫻井孝宏,植田佳奈,森久保祥太郎,雪乃五月,飛田展男,大塚明夫,茶風林,長島雄一,岩田光央,麦人","categories":"动画","release_time":"2001-10-14","areas":"日本","vertical_cover_url":"http://pc.wangpan.xycdn.n0808.com/2f053ad68201e96017c30c715cc734d1.jpg","popcorn_index":0.7692308},{"id":"5dbbd81e4df7f1000101fb5a","movie_id":101251,"created_on":1572591646454922800,"name":"电脑奇侠","directors":"北村秀敏,永野靖忠,畠山豊彦","actors":"伴大介,飯塚昭三,真山譲次,伊豆肇,水の江じゅん","categories":"动作,科幻,冒险","release_time":"1972-07-08","areas":"日本","vertical_cover_url":"http://pc.wangpan.xycdn.n0808.com/9e554187bf986dd51f65e277eb159095.jpg","popcorn_index":0},{"id":"5dbbd81e4df7f1000101fb59","movie_id":371,"created_on":1572591646454889000,"name":"流动的天空","directors":"斯拉瓦·祖克曼","actors":"Anne Carlisle,Paula E. Sheppard,Susan Doukas","categories":"喜剧,科幻","release_time":"1983-10-14","areas":"美国","vertical_cover_url":"http://pc.wangpan.xycdn.n0808.com/0d96dd26176afd946f6e6953813c777b.jpg","popcorn_index":0.8095238},{"id":"5dbbd81e4df7f1000101fb58","movie_id":5062,"created_on":1572591646454770000,"name":"终结者","directors":"詹姆斯·卡梅隆","actors":"阿诺·施瓦辛格,琳达·汉密尔顿,迈克尔·比恩,保罗·温菲尔德,兰斯·亨利克森,里克·罗索维奇,贝丝·莫塔,阿尔·伯恩,迪克·米勒,弗兰科·哥伦布,比尔·帕克斯顿,布莱恩·汤普森,小威廉·威谢尔,菲利普·戈登,Stan Yale,哈丽特·梅丁,Norman Friedman,Barbara Powers,Chino 'Fats' Williams,玛丽安妮·穆勒雷尔,达雷尔·马普森","categories":"动作,科幻,惊悚","release_time":"1992-06(中国","areas":"美国,英国","vertical_cover_url":"http://pc.wangpan.xycdn.n0808.com/dc8c88cd4eb5c4d539fde302a5087c78.jpg","popcorn_index":0.8623482},{"id":"5dbbd81e4df7f1000101fb54","movie_id":7827,"created_on":1572591646447295500,"name":"神秘美人局","directors":"迈克尔·克莱顿","actors":"阿尔伯特·芬尼,James Coburn,Susan Dey","categories":"剧情,科幻,惊悚","release_time":"1981-10-30","areas":"美国","vertical_cover_url":"http://pc.wangpan.xycdn.n0808.com/32fcaa1b25539964d522ea7aac3d5193.jpg","popcorn_index":0.75},{"id":"5dbbd81e4df7f1000101fb57","movie_id":4681,"created_on":1572591646447184100,"name":"未来世界","directors":"理查德·赫夫伦","actors":"彼得·方达,布莱思·丹纳,阿瑟·希尔,尤·伯连纳,约翰·P.瑞安,斯图尔特·马戈林,Allen Ludden,罗伯特·科恩斯韦特,Angela Greene,达雷尔·拉森,Nancy Bell,Bert Conroy,Dorothy Konrad,John Fujioka,Dana Lee","categories":"科幻,惊悚","release_time":"1976-08-13","areas":"美国","vertical_cover_url":"http://pc.wangpan.xycdn.n0808.com/2b908e3ad4414931a02443c8df80210d.jpg","popcorn_index":0.8095238},{"id":"5dbbd81e4df7f1000101fb56","movie_id":1021,"created_on":1572591646447157800,"name":"战争游戏","directors":"约翰·班德汉姆","actors":"马修·布罗德里克,艾丽·西蒂","categories":"剧情,惊悚","release_time":"1983-12-22","areas":"美国","vertical_cover_url":"http://pc.wangpan.xycdn.n0808.com/3114e450c8acfabd8d7d8aa7d73ba525.jpg","popcorn_index":0.8125},{"id":"5dbbd81e4df7f1000101fb52","movie_id":4266,"created_on":1572591646447155500,"name":"500年后","directors":"乔治·卢卡斯","actors":"罗伯特·杜瓦尔,唐纳德·普利森斯,唐佩德罗·科利","categories":"剧情,科幻,悬疑,惊悚","release_time":"1971-03-11","areas":"美国","vertical_cover_url":"http://pc.wangpan.xycdn.n0808.com/9daa90a9223023d79564d4e57e2f1919.jpg","popcorn_index":0.7826087},{"id":"5dbbd81e4df7f1000101fb4e","movie_id":12743,"created_on":1572591646447109400,"name":"爆裂都市","directors":"石井聪互","actors":"阵内孝则,大江慎也,泉谷しげる","categories":"动作,科幻,音乐","release_time":"1982-03-13","areas":"日本","vertical_cover_url":"http://pc.wangpan.xycdn.n0808.com/d88271b71620d1102e5271ebe8cebbb1.jpg","popcorn_index":0.7692308},{"id":"5dbbd81e4df7f1000101fb4f","movie_id":1857,"created_on":1572591646447093200,"name":"机器战警","directors":"保罗·范霍文","actors":"彼得·威勒,南茜·艾伦,丹·奥赫里奇,罗尼·考克斯,柯特伍德·史密斯","categories":"剧情,动作,科幻,惊悚,犯罪","release_time":"1987-07-17","areas":"美国","vertical_cover_url":"http://pc.wangpan.xycdn.n0808.com/7e72148d93cdb899b5cd66f38cf8214e.jpg","popcorn_index":0.7763158},{"id":"5dbbd81e4df7f1000101fb53","movie_id":3344,"created_on":1572591646447084800,"name":"天雷地火","directors":"阿尔伯特·派恩","actors":"尚格·云顿","categories":"动作,科幻","release_time":"1989-04-07","areas":"美国","vertical_cover_url":"http://pc.wangpan.xycdn.n0808.com/d49b2a25a4d1cec0ebeb16983f85b353.jpg","popcorn_index":0.7368421}],"passwd":"","remark_list":null,"total":17}
     * msg : ok
     */

    private int code;
    private DataBean data;
    private String msg;

    public static PianDianSingleDetails objectFromData(String str) {

        return new Gson().fromJson(str, PianDianSingleDetails.class);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        /**
         * info : {"created_on":1572591646307425500,"id":"5dcc664394b02600010401a4","name":"赛博朋克风科幻电影","description":"真·赛博朋克风格科幻电影盘点","uid":"696005791","is_original":0,"pointer_id":"5dbbd81e94b0260001028352","is_default":0,"cover_url1":"http://pc.wangpan.xycdn.n0808.com/5ea4803e0f6cac7a4731f240fb44e940.jpg","cover_url2":"http://pc.wangpan.xycdn.n0808.com/d2de9168049341c2eb0971e8317034cd.jpg","cover_url3":"http://pc.wangpan.xycdn.n0808.com/62fd2503d304e99e6f71f7dfe4691b14.jpg","num":17,"num_upvote":0,"num_fav":2,"status":0,"name_check":2,"desc_check":2,"updated_on":1572591672472488400,"modified_on":1572591807019542300,"deleted_on":0,"fav_status":false,"vote_status":false,"user_name":"热心市民","user_avatar":"https://xfile2.a.88cdn.com/file/k/FkEmbOVyEZuUEB4S0NF2iAR2cFOb/300x300"}
         * list : [{"id":"5dbbd81e4df7f1000101fb50","movie_id":50024,"created_on":1572591806981514800,"name":"攻壳机动队","directors":"鲁伯特·桑德斯","actors":"斯嘉丽·约翰逊,皮鲁·埃斯贝克,北野武,朱丽叶·比诺什,迈克尔·皮特,黄经汉,丹妮西娅·萨马尔,拉札勒斯·雷图勒,泉原豊,托万达·马尼莫,彼得·费迪南多,安娜玛丽亚·玛琳卡,丹尼尔·亨绍尔,安德鲁·斯特林,桃井薰,查尔斯·欧比,福岛莉拉,约瑟夫·纳瓦胡,迈克尔·维克特","categories":"动作,科幻,犯罪","release_time":"2017-04-07","areas":"美国","vertical_cover_url":"http://pc.wangpan.xycdn.n0808.com/5ea4803e0f6cac7a4731f240fb44e940.jpg","popcorn_index":0.73333335},{"id":"5dbbd81e4df7f1000101fb5e","movie_id":2412,"created_on":1572591646457417500,"name":"纽约大逃亡","directors":"约翰·卡朋特","actors":"库尔特·拉塞尔,李·范·克里夫,欧内斯特·博格宁,唐纳德·普利森斯,艾萨克·海耶斯","categories":"动作,科幻,冒险","release_time":"1981-05-23","areas":"英国,美国","vertical_cover_url":"http://pc.wangpan.xycdn.n0808.com/d2de9168049341c2eb0971e8317034cd.jpg","popcorn_index":0.77272725},{"id":"5dbbd81e4df7f1000101fb5d","movie_id":57,"created_on":1572591646455081000,"name":"银翼杀手","directors":"雷德利·斯科特","actors":"哈里森·福特,鲁特格尔·哈尔,肖恩·杨,爱德华·詹姆斯·奥莫斯,M·埃梅特·沃尔什,达丽尔·汉纳,威廉·桑德森,布里翁·詹姆斯,乔·托克尔,乔安娜·卡西迪,吴汉章,摩根·保罗,凯文·汤普森","categories":"科幻,惊悚","release_time":"1982-06-25","areas":"美国,香港","vertical_cover_url":"http://pc.wangpan.xycdn.n0808.com/62fd2503d304e99e6f71f7dfe4691b14.jpg","popcorn_index":0.81672025},{"id":"5dbbd81e4df7f1000101fb5b","movie_id":3915,"created_on":1572591646455054000,"name":"机器战警2","directors":"厄文·克什纳","actors":"彼得·威勒,南茜·艾伦,加布里埃尔·达蒙,莉扎·吉邦斯","categories":"动作,科幻,惊悚,犯罪","release_time":"1990-06-22","areas":"美国","vertical_cover_url":"http://pc.wangpan.xycdn.n0808.com/82b2ef5156735f8dc9096988de9f72cf.jpg","popcorn_index":0.7619048},{"id":"5dbbd81e4df7f1000101fb5c","movie_id":61025,"created_on":1572591646455048000,"name":"人造人009","directors":"川越淳","actors":"櫻井孝宏,植田佳奈,森久保祥太郎,雪乃五月,飛田展男,大塚明夫,茶風林,長島雄一,岩田光央,麦人","categories":"动画","release_time":"2001-10-14","areas":"日本","vertical_cover_url":"http://pc.wangpan.xycdn.n0808.com/2f053ad68201e96017c30c715cc734d1.jpg","popcorn_index":0.7692308},{"id":"5dbbd81e4df7f1000101fb5a","movie_id":101251,"created_on":1572591646454922800,"name":"电脑奇侠","directors":"北村秀敏,永野靖忠,畠山豊彦","actors":"伴大介,飯塚昭三,真山譲次,伊豆肇,水の江じゅん","categories":"动作,科幻,冒险","release_time":"1972-07-08","areas":"日本","vertical_cover_url":"http://pc.wangpan.xycdn.n0808.com/9e554187bf986dd51f65e277eb159095.jpg","popcorn_index":0},{"id":"5dbbd81e4df7f1000101fb59","movie_id":371,"created_on":1572591646454889000,"name":"流动的天空","directors":"斯拉瓦·祖克曼","actors":"Anne Carlisle,Paula E. Sheppard,Susan Doukas","categories":"喜剧,科幻","release_time":"1983-10-14","areas":"美国","vertical_cover_url":"http://pc.wangpan.xycdn.n0808.com/0d96dd26176afd946f6e6953813c777b.jpg","popcorn_index":0.8095238},{"id":"5dbbd81e4df7f1000101fb58","movie_id":5062,"created_on":1572591646454770000,"name":"终结者","directors":"詹姆斯·卡梅隆","actors":"阿诺·施瓦辛格,琳达·汉密尔顿,迈克尔·比恩,保罗·温菲尔德,兰斯·亨利克森,里克·罗索维奇,贝丝·莫塔,阿尔·伯恩,迪克·米勒,弗兰科·哥伦布,比尔·帕克斯顿,布莱恩·汤普森,小威廉·威谢尔,菲利普·戈登,Stan Yale,哈丽特·梅丁,Norman Friedman,Barbara Powers,Chino 'Fats' Williams,玛丽安妮·穆勒雷尔,达雷尔·马普森","categories":"动作,科幻,惊悚","release_time":"1992-06(中国","areas":"美国,英国","vertical_cover_url":"http://pc.wangpan.xycdn.n0808.com/dc8c88cd4eb5c4d539fde302a5087c78.jpg","popcorn_index":0.8623482},{"id":"5dbbd81e4df7f1000101fb54","movie_id":7827,"created_on":1572591646447295500,"name":"神秘美人局","directors":"迈克尔·克莱顿","actors":"阿尔伯特·芬尼,James Coburn,Susan Dey","categories":"剧情,科幻,惊悚","release_time":"1981-10-30","areas":"美国","vertical_cover_url":"http://pc.wangpan.xycdn.n0808.com/32fcaa1b25539964d522ea7aac3d5193.jpg","popcorn_index":0.75},{"id":"5dbbd81e4df7f1000101fb57","movie_id":4681,"created_on":1572591646447184100,"name":"未来世界","directors":"理查德·赫夫伦","actors":"彼得·方达,布莱思·丹纳,阿瑟·希尔,尤·伯连纳,约翰·P.瑞安,斯图尔特·马戈林,Allen Ludden,罗伯特·科恩斯韦特,Angela Greene,达雷尔·拉森,Nancy Bell,Bert Conroy,Dorothy Konrad,John Fujioka,Dana Lee","categories":"科幻,惊悚","release_time":"1976-08-13","areas":"美国","vertical_cover_url":"http://pc.wangpan.xycdn.n0808.com/2b908e3ad4414931a02443c8df80210d.jpg","popcorn_index":0.8095238},{"id":"5dbbd81e4df7f1000101fb56","movie_id":1021,"created_on":1572591646447157800,"name":"战争游戏","directors":"约翰·班德汉姆","actors":"马修·布罗德里克,艾丽·西蒂","categories":"剧情,惊悚","release_time":"1983-12-22","areas":"美国","vertical_cover_url":"http://pc.wangpan.xycdn.n0808.com/3114e450c8acfabd8d7d8aa7d73ba525.jpg","popcorn_index":0.8125},{"id":"5dbbd81e4df7f1000101fb52","movie_id":4266,"created_on":1572591646447155500,"name":"500年后","directors":"乔治·卢卡斯","actors":"罗伯特·杜瓦尔,唐纳德·普利森斯,唐佩德罗·科利","categories":"剧情,科幻,悬疑,惊悚","release_time":"1971-03-11","areas":"美国","vertical_cover_url":"http://pc.wangpan.xycdn.n0808.com/9daa90a9223023d79564d4e57e2f1919.jpg","popcorn_index":0.7826087},{"id":"5dbbd81e4df7f1000101fb4e","movie_id":12743,"created_on":1572591646447109400,"name":"爆裂都市","directors":"石井聪互","actors":"阵内孝则,大江慎也,泉谷しげる","categories":"动作,科幻,音乐","release_time":"1982-03-13","areas":"日本","vertical_cover_url":"http://pc.wangpan.xycdn.n0808.com/d88271b71620d1102e5271ebe8cebbb1.jpg","popcorn_index":0.7692308},{"id":"5dbbd81e4df7f1000101fb4f","movie_id":1857,"created_on":1572591646447093200,"name":"机器战警","directors":"保罗·范霍文","actors":"彼得·威勒,南茜·艾伦,丹·奥赫里奇,罗尼·考克斯,柯特伍德·史密斯","categories":"剧情,动作,科幻,惊悚,犯罪","release_time":"1987-07-17","areas":"美国","vertical_cover_url":"http://pc.wangpan.xycdn.n0808.com/7e72148d93cdb899b5cd66f38cf8214e.jpg","popcorn_index":0.7763158},{"id":"5dbbd81e4df7f1000101fb53","movie_id":3344,"created_on":1572591646447084800,"name":"天雷地火","directors":"阿尔伯特·派恩","actors":"尚格·云顿","categories":"动作,科幻","release_time":"1989-04-07","areas":"美国","vertical_cover_url":"http://pc.wangpan.xycdn.n0808.com/d49b2a25a4d1cec0ebeb16983f85b353.jpg","popcorn_index":0.7368421}]
         * passwd :
         * remark_list : null
         * total : 17
         */

        private InfoBean info;
        private String passwd;
        private Object remark_list;
        private int total;
        private List<ListBean> list;

        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
        }

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }

        public String getPasswd() {
            return passwd;
        }

        public void setPasswd(String passwd) {
            this.passwd = passwd;
        }

        public Object getRemark_list() {
            return remark_list;
        }

        public void setRemark_list(Object remark_list) {
            this.remark_list = remark_list;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class InfoBean {
            /**
             * created_on : 1572591646307425500
             * id : 5dcc664394b02600010401a4
             * name : 赛博朋克风科幻电影
             * description : 真·赛博朋克风格科幻电影盘点
             * uid : 696005791
             * is_original : 0
             * pointer_id : 5dbbd81e94b0260001028352
             * is_default : 0
             * cover_url1 : http://pc.wangpan.xycdn.n0808.com/5ea4803e0f6cac7a4731f240fb44e940.jpg
             * cover_url2 : http://pc.wangpan.xycdn.n0808.com/d2de9168049341c2eb0971e8317034cd.jpg
             * cover_url3 : http://pc.wangpan.xycdn.n0808.com/62fd2503d304e99e6f71f7dfe4691b14.jpg
             * num : 17
             * num_upvote : 0
             * num_fav : 2
             * status : 0
             * name_check : 2
             * desc_check : 2
             * updated_on : 1572591672472488400
             * modified_on : 1572591807019542300
             * deleted_on : 0
             * fav_status : false
             * vote_status : false
             * user_name : 热心市民
             * user_avatar : https://xfile2.a.88cdn.com/file/k/FkEmbOVyEZuUEB4S0NF2iAR2cFOb/300x300
             */

            private long created_on;
            private String id;
            private String name;
            private String description;
            private String uid;
            private int is_original;
            private String pointer_id;
            private int is_default;
            private String cover_url1;
            private String cover_url2;
            private String cover_url3;
            private int num;
            private int num_upvote;
            private int num_fav;
            private int status;
            private int name_check;
            private int desc_check;
            private long updated_on;
            private long modified_on;
            private int deleted_on;
            private boolean fav_status;
            private boolean vote_status;
            private String user_name;
            private String user_avatar;

            public static InfoBean objectFromData(String str) {

                return new Gson().fromJson(str, InfoBean.class);
            }

            public long getCreated_on() {
                return created_on;
            }

            public void setCreated_on(long created_on) {
                this.created_on = created_on;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public int getIs_original() {
                return is_original;
            }

            public void setIs_original(int is_original) {
                this.is_original = is_original;
            }

            public String getPointer_id() {
                return pointer_id;
            }

            public void setPointer_id(String pointer_id) {
                this.pointer_id = pointer_id;
            }

            public int getIs_default() {
                return is_default;
            }

            public void setIs_default(int is_default) {
                this.is_default = is_default;
            }

            public String getCover_url1() {
                return cover_url1;
            }

            public void setCover_url1(String cover_url1) {
                this.cover_url1 = cover_url1;
            }

            public String getCover_url2() {
                return cover_url2;
            }

            public void setCover_url2(String cover_url2) {
                this.cover_url2 = cover_url2;
            }

            public String getCover_url3() {
                return cover_url3;
            }

            public void setCover_url3(String cover_url3) {
                this.cover_url3 = cover_url3;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public int getNum_upvote() {
                return num_upvote;
            }

            public void setNum_upvote(int num_upvote) {
                this.num_upvote = num_upvote;
            }

            public int getNum_fav() {
                return num_fav;
            }

            public void setNum_fav(int num_fav) {
                this.num_fav = num_fav;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getName_check() {
                return name_check;
            }

            public void setName_check(int name_check) {
                this.name_check = name_check;
            }

            public int getDesc_check() {
                return desc_check;
            }

            public void setDesc_check(int desc_check) {
                this.desc_check = desc_check;
            }

            public long getUpdated_on() {
                return updated_on;
            }

            public void setUpdated_on(long updated_on) {
                this.updated_on = updated_on;
            }

            public long getModified_on() {
                return modified_on;
            }

            public void setModified_on(long modified_on) {
                this.modified_on = modified_on;
            }

            public int getDeleted_on() {
                return deleted_on;
            }

            public void setDeleted_on(int deleted_on) {
                this.deleted_on = deleted_on;
            }

            public boolean isFav_status() {
                return fav_status;
            }

            public void setFav_status(boolean fav_status) {
                this.fav_status = fav_status;
            }

            public boolean isVote_status() {
                return vote_status;
            }

            public void setVote_status(boolean vote_status) {
                this.vote_status = vote_status;
            }

            public String getUser_name() {
                return user_name;
            }

            public void setUser_name(String user_name) {
                this.user_name = user_name;
            }

            public String getUser_avatar() {
                return user_avatar;
            }

            public void setUser_avatar(String user_avatar) {
                this.user_avatar = user_avatar;
            }
        }

        public static class ListBean {
            /**
             * id : 5dbbd81e4df7f1000101fb50
             * movie_id : 50024
             * created_on : 1572591806981514800
             * name : 攻壳机动队
             * directors : 鲁伯特·桑德斯
             * actors : 斯嘉丽·约翰逊,皮鲁·埃斯贝克,北野武,朱丽叶·比诺什,迈克尔·皮特,黄经汉,丹妮西娅·萨马尔,拉札勒斯·雷图勒,泉原豊,托万达·马尼莫,彼得·费迪南多,安娜玛丽亚·玛琳卡,丹尼尔·亨绍尔,安德鲁·斯特林,桃井薰,查尔斯·欧比,福岛莉拉,约瑟夫·纳瓦胡,迈克尔·维克特
             * categories : 动作,科幻,犯罪
             * release_time : 2017-04-07
             * areas : 美国
             * vertical_cover_url : http://pc.wangpan.xycdn.n0808.com/5ea4803e0f6cac7a4731f240fb44e940.jpg
             * popcorn_index : 0.73333335
             */

            private String id;
            private int movie_id;
            private long created_on;
            private String name;
            private String directors;
            private String actors;
            private String categories;
            private String release_time;
            private String areas;
            private String vertical_cover_url;
            private double popcorn_index;

            public static ListBean objectFromData(String str) {

                return new Gson().fromJson(str, ListBean.class);
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public int getMovie_id() {
                return movie_id;
            }

            public void setMovie_id(int movie_id) {
                this.movie_id = movie_id;
            }

            public long getCreated_on() {
                return created_on;
            }

            public void setCreated_on(long created_on) {
                this.created_on = created_on;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDirectors() {
                return directors;
            }

            public void setDirectors(String directors) {
                this.directors = directors;
            }

            public String getActors() {
                return actors;
            }

            public void setActors(String actors) {
                this.actors = actors;
            }

            public String getCategories() {
                return categories;
            }

            public void setCategories(String categories) {
                this.categories = categories;
            }

            public String getRelease_time() {
                return release_time;
            }

            public void setRelease_time(String release_time) {
                this.release_time = release_time;
            }

            public String getAreas() {
                return areas;
            }

            public void setAreas(String areas) {
                this.areas = areas;
            }

            public String getVertical_cover_url() {
                return vertical_cover_url;
            }

            public void setVertical_cover_url(String vertical_cover_url) {
                this.vertical_cover_url = vertical_cover_url;
            }

            public double getPopcorn_index() {
                return popcorn_index;
            }

            public void setPopcorn_index(double popcorn_index) {
                this.popcorn_index = popcorn_index;
            }
        }
    }
}
