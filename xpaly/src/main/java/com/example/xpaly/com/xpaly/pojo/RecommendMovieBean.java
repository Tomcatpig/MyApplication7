package com.example.xpaly.com.xpaly.pojo;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @创建者 tw
 * @创建时间 2019/12/9
 * @描述
 */
public class RecommendMovieBean {


    /**
     * code : 0
     * result : ok
     * data : {"has_more":true,"next_cursor":21,"array":[{"cinecism":{"id":137727,"id_s":"137727","uid":531463950,"uid_s":"531463950","title":"这对千年CP，再也藏不住了","summary":"文/陈佳俊编辑/西西弗斯不知道现在推荐这部剧，还算不算晚。它的名字让人有些摸不着头脑，却意外诞生了今年最甜的一对CP。自从摆脱了《权游》烂尾的阴影，这段时间刷了不少好剧，《使女的故事》、《大小谎言》.","cover_url":"http://pc.wangpan.xycdn.n0808.com/440b66682741ec75b10fb4cb223238e0","body_url":"http://pc.wangpan.xycdn.n0808.com/d73397e5e1ac7ac0741ec48f944cb245","media_id":"90767","tag":"","origin":1,"spoiler":0,"source":"wx","status":1,"lock_status":0,"create_time":1562754001,"image_num":23,"image_list":["http://pc.wangpan.xycdn.n0808.com/0d904e9d71b377abce5a7cd414a44235","http://pc.wangpan.xycdn.n0808.com/0d9c457515cf27dd41cdfc1a827966c5","http://pc.wangpan.xycdn.n0808.com/c9efbadc175673249c43d0d062b6a7e1"],"poster_list":[],"video_num":0,"have_fav":false,"fav_count":33,"show_count":2889,"share_count":0,"comment_count":19,"activity_id":0,"activity_id_s":"","university":"","medal":0},"media_info":{"name":"好兆头","vertical_cover_url":"http://pc.wangpan.xycdn.n0808.com/797c079f80cda5d0426fd21c756b9842.jpg","release_time":"2019-05-31"},"movie_score":{"movie_id":90767,"popcorn_index":0.95454544,"unworthy":6,"worthy":126},"movie_evaluation":-2,"movie_collected":false}],"user_info":{"531463950":{"nick_name":"电影爬虫","portrait_url":"https://xfile2.a.88cdn.com/file/k/531463950/avatar/1544615598.jpg/300x300"}}}
     */

    private int code;
    private String result;
    private DataBean data;

    public static RecommendMovieBean objectFromData(String str) {

        return new Gson().fromJson(str, RecommendMovieBean.class);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * has_more : true
         * next_cursor : 21
         * array : [{"cinecism":{"id":137727,"id_s":"137727","uid":531463950,"uid_s":"531463950","title":"这对千年CP，再也藏不住了","summary":"文/陈佳俊编辑/西西弗斯不知道现在推荐这部剧，还算不算晚。它的名字让人有些摸不着头脑，却意外诞生了今年最甜的一对CP。自从摆脱了《权游》烂尾的阴影，这段时间刷了不少好剧，《使女的故事》、《大小谎言》.","cover_url":"http://pc.wangpan.xycdn.n0808.com/440b66682741ec75b10fb4cb223238e0","body_url":"http://pc.wangpan.xycdn.n0808.com/d73397e5e1ac7ac0741ec48f944cb245","media_id":"90767","tag":"","origin":1,"spoiler":0,"source":"wx","status":1,"lock_status":0,"create_time":1562754001,"image_num":23,"image_list":["http://pc.wangpan.xycdn.n0808.com/0d904e9d71b377abce5a7cd414a44235","http://pc.wangpan.xycdn.n0808.com/0d9c457515cf27dd41cdfc1a827966c5","http://pc.wangpan.xycdn.n0808.com/c9efbadc175673249c43d0d062b6a7e1"],"poster_list":[],"video_num":0,"have_fav":false,"fav_count":33,"show_count":2889,"share_count":0,"comment_count":19,"activity_id":0,"activity_id_s":"","university":"","medal":0},"media_info":{"name":"好兆头","vertical_cover_url":"http://pc.wangpan.xycdn.n0808.com/797c079f80cda5d0426fd21c756b9842.jpg","release_time":"2019-05-31"},"movie_score":{"movie_id":90767,"popcorn_index":0.95454544,"unworthy":6,"worthy":126},"movie_evaluation":-2,"movie_collected":false}]
         * user_info : {"531463950":{"nick_name":"电影爬虫","portrait_url":"https://xfile2.a.88cdn.com/file/k/531463950/avatar/1544615598.jpg/300x300"}}
         */

        private boolean has_more;
        private int next_cursor;
        private UserInfoBean user_info;
        private List<ArrayBean> array;

        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
        }

        public boolean isHas_more() {
            return has_more;
        }

        public void setHas_more(boolean has_more) {
            this.has_more = has_more;
        }

        public int getNext_cursor() {
            return next_cursor;
        }

        public void setNext_cursor(int next_cursor) {
            this.next_cursor = next_cursor;
        }

        public UserInfoBean getUser_info() {
            return user_info;
        }

        public void setUser_info(UserInfoBean user_info) {
            this.user_info = user_info;
        }

        public List<ArrayBean> getArray() {
            return array;
        }

        public void setArray(List<ArrayBean> array) {
            this.array = array;
        }

        public static class UserInfoBean {
            /**
             * 531463950 : {"nick_name":"电影爬虫","portrait_url":"https://xfile2.a.88cdn.com/file/k/531463950/avatar/1544615598.jpg/300x300"}
             */

            @SerializedName("531463950")
            private _$531463950Bean _$531463950;

            public static UserInfoBean objectFromData(String str) {

                return new Gson().fromJson(str, UserInfoBean.class);
            }

            public _$531463950Bean get_$531463950() {
                return _$531463950;
            }

            public void set_$531463950(_$531463950Bean _$531463950) {
                this._$531463950 = _$531463950;
            }

            public static class _$531463950Bean {
                /**
                 * nick_name : 电影爬虫
                 * portrait_url : https://xfile2.a.88cdn.com/file/k/531463950/avatar/1544615598.jpg/300x300
                 */

                private String nick_name;
                private String portrait_url;

                public static _$531463950Bean objectFromData(String str) {

                    return new Gson().fromJson(str, _$531463950Bean.class);
                }

                public String getNick_name() {
                    return nick_name;
                }

                public void setNick_name(String nick_name) {
                    this.nick_name = nick_name;
                }

                public String getPortrait_url() {
                    return portrait_url;
                }

                public void setPortrait_url(String portrait_url) {
                    this.portrait_url = portrait_url;
                }
            }
        }

        public static class ArrayBean {
            /**
             * cinecism : {"id":137727,"id_s":"137727","uid":531463950,"uid_s":"531463950","title":"这对千年CP，再也藏不住了","summary":"文/陈佳俊编辑/西西弗斯不知道现在推荐这部剧，还算不算晚。它的名字让人有些摸不着头脑，却意外诞生了今年最甜的一对CP。自从摆脱了《权游》烂尾的阴影，这段时间刷了不少好剧，《使女的故事》、《大小谎言》.","cover_url":"http://pc.wangpan.xycdn.n0808.com/440b66682741ec75b10fb4cb223238e0","body_url":"http://pc.wangpan.xycdn.n0808.com/d73397e5e1ac7ac0741ec48f944cb245","media_id":"90767","tag":"","origin":1,"spoiler":0,"source":"wx","status":1,"lock_status":0,"create_time":1562754001,"image_num":23,"image_list":["http://pc.wangpan.xycdn.n0808.com/0d904e9d71b377abce5a7cd414a44235","http://pc.wangpan.xycdn.n0808.com/0d9c457515cf27dd41cdfc1a827966c5","http://pc.wangpan.xycdn.n0808.com/c9efbadc175673249c43d0d062b6a7e1"],"poster_list":[],"video_num":0,"have_fav":false,"fav_count":33,"show_count":2889,"share_count":0,"comment_count":19,"activity_id":0,"activity_id_s":"","university":"","medal":0}
             * media_info : {"name":"好兆头","vertical_cover_url":"http://pc.wangpan.xycdn.n0808.com/797c079f80cda5d0426fd21c756b9842.jpg","release_time":"2019-05-31"}
             * movie_score : {"movie_id":90767,"popcorn_index":0.95454544,"unworthy":6,"worthy":126}
             * movie_evaluation : -2
             * movie_collected : false
             */

            private CinecismBean cinecism;
            private MediaInfoBean media_info;
            private MovieScoreBean movie_score;
            private int movie_evaluation;
            private boolean movie_collected;

            public static ArrayBean objectFromData(String str) {

                return new Gson().fromJson(str, ArrayBean.class);
            }

            public CinecismBean getCinecism() {
                return cinecism;
            }

            public void setCinecism(CinecismBean cinecism) {
                this.cinecism = cinecism;
            }

            public MediaInfoBean getMedia_info() {
                return media_info;
            }

            public void setMedia_info(MediaInfoBean media_info) {
                this.media_info = media_info;
            }

            public MovieScoreBean getMovie_score() {
                return movie_score;
            }

            public void setMovie_score(MovieScoreBean movie_score) {
                this.movie_score = movie_score;
            }

            public int getMovie_evaluation() {
                return movie_evaluation;
            }

            public void setMovie_evaluation(int movie_evaluation) {
                this.movie_evaluation = movie_evaluation;
            }

            public boolean isMovie_collected() {
                return movie_collected;
            }

            public void setMovie_collected(boolean movie_collected) {
                this.movie_collected = movie_collected;
            }

            public static class CinecismBean {
                /**
                 * id : 137727
                 * id_s : 137727
                 * uid : 531463950
                 * uid_s : 531463950
                 * title : 这对千年CP，再也藏不住了
                 * summary : 文/陈佳俊编辑/西西弗斯不知道现在推荐这部剧，还算不算晚。它的名字让人有些摸不着头脑，却意外诞生了今年最甜的一对CP。自从摆脱了《权游》烂尾的阴影，这段时间刷了不少好剧，《使女的故事》、《大小谎言》.
                 * cover_url : http://pc.wangpan.xycdn.n0808.com/440b66682741ec75b10fb4cb223238e0
                 * body_url : http://pc.wangpan.xycdn.n0808.com/d73397e5e1ac7ac0741ec48f944cb245
                 * media_id : 90767
                 * tag :
                 * origin : 1
                 * spoiler : 0
                 * source : wx
                 * status : 1
                 * lock_status : 0
                 * create_time : 1562754001
                 * image_num : 23
                 * image_list : ["http://pc.wangpan.xycdn.n0808.com/0d904e9d71b377abce5a7cd414a44235","http://pc.wangpan.xycdn.n0808.com/0d9c457515cf27dd41cdfc1a827966c5","http://pc.wangpan.xycdn.n0808.com/c9efbadc175673249c43d0d062b6a7e1"]
                 * poster_list : []
                 * video_num : 0
                 * have_fav : false
                 * fav_count : 33
                 * show_count : 2889
                 * share_count : 0
                 * comment_count : 19
                 * activity_id : 0
                 * activity_id_s :
                 * university :
                 * medal : 0
                 */

                private int id;
                private String id_s;
                private int uid;
                private String uid_s;
                private String title;
                private String summary;
                private String cover_url;
                private String body_url;
                private String media_id;
                private String tag;
                private int origin;
                private int spoiler;
                private String source;
                private int status;
                private int lock_status;
                private int create_time;
                private int image_num;
                private int video_num;
                private boolean have_fav;
                private int fav_count;
                private int show_count;
                private int share_count;
                private int comment_count;
                private int activity_id;
                private String activity_id_s;
                private String university;
                private int medal;
                private List<String> image_list;
                private List<?> poster_list;

                public static CinecismBean objectFromData(String str) {

                    return new Gson().fromJson(str, CinecismBean.class);
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getId_s() {
                    return id_s;
                }

                public void setId_s(String id_s) {
                    this.id_s = id_s;
                }

                public int getUid() {
                    return uid;
                }

                public void setUid(int uid) {
                    this.uid = uid;
                }

                public String getUid_s() {
                    return uid_s;
                }

                public void setUid_s(String uid_s) {
                    this.uid_s = uid_s;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getSummary() {
                    return summary;
                }

                public void setSummary(String summary) {
                    this.summary = summary;
                }

                public String getCover_url() {
                    return cover_url;
                }

                public void setCover_url(String cover_url) {
                    this.cover_url = cover_url;
                }

                public String getBody_url() {
                    return body_url;
                }

                public void setBody_url(String body_url) {
                    this.body_url = body_url;
                }

                public String getMedia_id() {
                    return media_id;
                }

                public void setMedia_id(String media_id) {
                    this.media_id = media_id;
                }

                public String getTag() {
                    return tag;
                }

                public void setTag(String tag) {
                    this.tag = tag;
                }

                public int getOrigin() {
                    return origin;
                }

                public void setOrigin(int origin) {
                    this.origin = origin;
                }

                public int getSpoiler() {
                    return spoiler;
                }

                public void setSpoiler(int spoiler) {
                    this.spoiler = spoiler;
                }

                public String getSource() {
                    return source;
                }

                public void setSource(String source) {
                    this.source = source;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public int getLock_status() {
                    return lock_status;
                }

                public void setLock_status(int lock_status) {
                    this.lock_status = lock_status;
                }

                public int getCreate_time() {
                    return create_time;
                }

                public void setCreate_time(int create_time) {
                    this.create_time = create_time;
                }

                public int getImage_num() {
                    return image_num;
                }

                public void setImage_num(int image_num) {
                    this.image_num = image_num;
                }

                public int getVideo_num() {
                    return video_num;
                }

                public void setVideo_num(int video_num) {
                    this.video_num = video_num;
                }

                public boolean isHave_fav() {
                    return have_fav;
                }

                public void setHave_fav(boolean have_fav) {
                    this.have_fav = have_fav;
                }

                public int getFav_count() {
                    return fav_count;
                }

                public void setFav_count(int fav_count) {
                    this.fav_count = fav_count;
                }

                public int getShow_count() {
                    return show_count;
                }

                public void setShow_count(int show_count) {
                    this.show_count = show_count;
                }

                public int getShare_count() {
                    return share_count;
                }

                public void setShare_count(int share_count) {
                    this.share_count = share_count;
                }

                public int getComment_count() {
                    return comment_count;
                }

                public void setComment_count(int comment_count) {
                    this.comment_count = comment_count;
                }

                public int getActivity_id() {
                    return activity_id;
                }

                public void setActivity_id(int activity_id) {
                    this.activity_id = activity_id;
                }

                public String getActivity_id_s() {
                    return activity_id_s;
                }

                public void setActivity_id_s(String activity_id_s) {
                    this.activity_id_s = activity_id_s;
                }

                public String getUniversity() {
                    return university;
                }

                public void setUniversity(String university) {
                    this.university = university;
                }

                public int getMedal() {
                    return medal;
                }

                public void setMedal(int medal) {
                    this.medal = medal;
                }

                public List<String> getImage_list() {
                    return image_list;
                }

                public void setImage_list(List<String> image_list) {
                    this.image_list = image_list;
                }

                public List<?> getPoster_list() {
                    return poster_list;
                }

                public void setPoster_list(List<?> poster_list) {
                    this.poster_list = poster_list;
                }
            }

            public static class MediaInfoBean {
                /**
                 * name : 好兆头
                 * vertical_cover_url : http://pc.wangpan.xycdn.n0808.com/797c079f80cda5d0426fd21c756b9842.jpg
                 * release_time : 2019-05-31
                 */

                private String name;
                private String vertical_cover_url;
                private String release_time;

                public static MediaInfoBean objectFromData(String str) {

                    return new Gson().fromJson(str, MediaInfoBean.class);
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getVertical_cover_url() {
                    return vertical_cover_url;
                }

                public void setVertical_cover_url(String vertical_cover_url) {
                    this.vertical_cover_url = vertical_cover_url;
                }

                public String getRelease_time() {
                    return release_time;
                }

                public void setRelease_time(String release_time) {
                    this.release_time = release_time;
                }
            }

            public static class MovieScoreBean {
                /**
                 * movie_id : 90767
                 * popcorn_index : 0.95454544
                 * unworthy : 6
                 * worthy : 126
                 */

                private int movie_id;
                private double popcorn_index;
                private int unworthy;
                private int worthy;

                public static MovieScoreBean objectFromData(String str) {

                    return new Gson().fromJson(str, MovieScoreBean.class);
                }

                public int getMovie_id() {
                    return movie_id;
                }

                public void setMovie_id(int movie_id) {
                    this.movie_id = movie_id;
                }

                public double getPopcorn_index() {
                    return popcorn_index;
                }

                public void setPopcorn_index(double popcorn_index) {
                    this.popcorn_index = popcorn_index;
                }

                public int getUnworthy() {
                    return unworthy;
                }

                public void setUnworthy(int unworthy) {
                    this.unworthy = unworthy;
                }

                public int getWorthy() {
                    return worthy;
                }

                public void setWorthy(int worthy) {
                    this.worthy = worthy;
                }
            }
        }
    }
}
