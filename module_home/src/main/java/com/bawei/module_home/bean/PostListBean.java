package com.bawei.module_home.bean;

import java.util.List;

/**
 * @ClassName PostListBean
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/10/19 8:49
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class PostListBean {

    /**
     * status : 200
     * message : 成功
     * data : {"data":[{"id":1578922430,"itemId":1615197740457,"itemType":2,"createTime":1615197740457,"duration":0,"feeds_text":"你见过的最虚荣的女生是什么样的?","authorId":1578919786,"activityIcon":null,"activityText":"放松时刻","width":1280,"height":720,"url":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/car.mp4","cover":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/car.jpeg","author":{"id":1755,"userId":1578919786,"name":"、蓅哖╰伊人为谁笑","avatar":"http://qzapp.qlogo.cn/qzapp/101794421/FE41683AD4ECF91B7736CA9DB8104A5C/100","description":"小朋友,你是否有很多问号","likeCount":4,"topCommentCount":10,"followCount":126,"followerCount":105,"qqOpenId":"FE41683AD4ECF91B7736CA9DB8104A5C","expires_time":1596726031266,"score":1000,"historyCount":4056,"commentCount":766,"favoriteCount":25,"feedCount":10,"hasFollow":false},"topComment":null,"ugc":{"likeCount":9824,"shareCount":147,"commentCount":10048,"hasFavorite":false,"hasLiked":false,"hasdiss":false,"hasDissed":false}},{"id":424,"itemId":1578921430555,"itemType":2,"createTime":1578977844501,"duration":30,"feeds_text":"感受下冬季的魔术吧","authorId":1578919786,"activityIcon":null,"activityText":"2019高光时刻","width":640,"height":360,"url":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/%E5%86%AC%E5%AD%A3%E7%9A%84%E9%AD%94%E6%9C%AFvideo.mp4","cover":"https://pipijoke.oss-cn-hangzhou.aliyuncs.com/%E5%86%AC%E5%AD%A3%E7%9A%84%E5%A5%A5%E7%A7%98.png","author":{"id":1755,"userId":1578919786,"name":"、蓅哖╰伊人为谁笑","avatar":"http://qzapp.qlogo.cn/qzapp/101794421/FE41683AD4ECF91B7736CA9DB8104A5C/100","description":"小朋友,你是否有很多问号","likeCount":4,"topCommentCount":10,"followCount":126,"followerCount":105,"qqOpenId":"FE41683AD4ECF91B7736CA9DB8104A5C","expires_time":1596726031266,"score":1000,"historyCount":4056,"commentCount":766,"favoriteCount":25,"feedCount":10,"hasFollow":false},"topComment":null,"ugc":{"likeCount":1954,"shareCount":34,"commentCount":548,"hasFavorite":false,"hasLiked":false,"hasdiss":false,"hasDissed":false}}]}
     */

    private int status;
    private String message;
    private PostDataBean postDataBean;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PostDataBean getPostDataBean() {
        return postDataBean;
    }

    public void setPostDataBean(PostDataBean postDataBean) {
        this.postDataBean = postDataBean;
    }

    public static class PostDataBean {
        /**
         * id : 1578922430
         * itemId : 1615197740457
         * itemType : 2
         * createTime : 1615197740457
         * duration : 0
         * feeds_text : 你见过的最虚荣的女生是什么样的?
         * authorId : 1578919786
         * activityIcon : null
         * activityText : 放松时刻
         * width : 1280
         * height : 720
         * url : https://pipijoke.oss-cn-hangzhou.aliyuncs.com/car.mp4
         * cover : https://pipijoke.oss-cn-hangzhou.aliyuncs.com/car.jpeg
         * author : {"id":1755,"userId":1578919786,"name":"、蓅哖╰伊人为谁笑","avatar":"http://qzapp.qlogo.cn/qzapp/101794421/FE41683AD4ECF91B7736CA9DB8104A5C/100","description":"小朋友,你是否有很多问号","likeCount":4,"topCommentCount":10,"followCount":126,"followerCount":105,"qqOpenId":"FE41683AD4ECF91B7736CA9DB8104A5C","expires_time":1596726031266,"score":1000,"historyCount":4056,"commentCount":766,"favoriteCount":25,"feedCount":10,"hasFollow":false}
         * topComment : null
         * ugc : {"likeCount":9824,"shareCount":147,"commentCount":10048,"hasFavorite":false,"hasLiked":false,"hasdiss":false,"hasDissed":false}
         */

        private List<DataBean> data;

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            private int id;
            private long itemId;
            private int itemType;
            private long createTime;
            private int duration;
            private String feeds_text;
            private int authorId;
            private Object activityIcon;
            private String activityText;
            private int width;
            private int height;
            private String url;
            private String cover;
            /**
             * id : 1755
             * userId : 1578919786
             * name : 、蓅哖╰伊人为谁笑
             * avatar : http://qzapp.qlogo.cn/qzapp/101794421/FE41683AD4ECF91B7736CA9DB8104A5C/100
             * description : 小朋友,你是否有很多问号
             * likeCount : 4
             * topCommentCount : 10
             * followCount : 126
             * followerCount : 105
             * qqOpenId : FE41683AD4ECF91B7736CA9DB8104A5C
             * expires_time : 1596726031266
             * score : 1000
             * historyCount : 4056
             * commentCount : 766
             * favoriteCount : 25
             * feedCount : 10
             * hasFollow : false
             */

            private AuthorBean author;
            private Object topComment;
            /**
             * likeCount : 9824
             * shareCount : 147
             * commentCount : 10048
             * hasFavorite : false
             * hasLiked : false
             * hasdiss : false
             * hasDissed : false
             */

            private UgcBean ugc;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public long getItemId() {
                return itemId;
            }

            public void setItemId(long itemId) {
                this.itemId = itemId;
            }

            public int getItemType() {
                return itemType;
            }

            public void setItemType(int itemType) {
                this.itemType = itemType;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public int getDuration() {
                return duration;
            }

            public void setDuration(int duration) {
                this.duration = duration;
            }

            public String getFeeds_text() {
                return feeds_text;
            }

            public void setFeeds_text(String feeds_text) {
                this.feeds_text = feeds_text;
            }

            public int getAuthorId() {
                return authorId;
            }

            public void setAuthorId(int authorId) {
                this.authorId = authorId;
            }

            public Object getActivityIcon() {
                return activityIcon;
            }

            public void setActivityIcon(Object activityIcon) {
                this.activityIcon = activityIcon;
            }

            public String getActivityText() {
                return activityText;
            }

            public void setActivityText(String activityText) {
                this.activityText = activityText;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public AuthorBean getAuthor() {
                return author;
            }

            public void setAuthor(AuthorBean author) {
                this.author = author;
            }

            public Object getTopComment() {
                return topComment;
            }

            public void setTopComment(Object topComment) {
                this.topComment = topComment;
            }

            public UgcBean getUgc() {
                return ugc;
            }

            public void setUgc(UgcBean ugc) {
                this.ugc = ugc;
            }

            public static class AuthorBean {
                private int id;
                private int userId;
                private String name;
                private String avatar;
                private String description;
                private int likeCount;
                private int topCommentCount;
                private int followCount;
                private int followerCount;
                private String qqOpenId;
                private long expires_time;
                private int score;
                private int historyCount;
                private int commentCount;
                private int favoriteCount;
                private int feedCount;
                private boolean hasFollow;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getUserId() {
                    return userId;
                }

                public void setUserId(int userId) {
                    this.userId = userId;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public int getLikeCount() {
                    return likeCount;
                }

                public void setLikeCount(int likeCount) {
                    this.likeCount = likeCount;
                }

                public int getTopCommentCount() {
                    return topCommentCount;
                }

                public void setTopCommentCount(int topCommentCount) {
                    this.topCommentCount = topCommentCount;
                }

                public int getFollowCount() {
                    return followCount;
                }

                public void setFollowCount(int followCount) {
                    this.followCount = followCount;
                }

                public int getFollowerCount() {
                    return followerCount;
                }

                public void setFollowerCount(int followerCount) {
                    this.followerCount = followerCount;
                }

                public String getQqOpenId() {
                    return qqOpenId;
                }

                public void setQqOpenId(String qqOpenId) {
                    this.qqOpenId = qqOpenId;
                }

                public long getExpires_time() {
                    return expires_time;
                }

                public void setExpires_time(long expires_time) {
                    this.expires_time = expires_time;
                }

                public int getScore() {
                    return score;
                }

                public void setScore(int score) {
                    this.score = score;
                }

                public int getHistoryCount() {
                    return historyCount;
                }

                public void setHistoryCount(int historyCount) {
                    this.historyCount = historyCount;
                }

                public int getCommentCount() {
                    return commentCount;
                }

                public void setCommentCount(int commentCount) {
                    this.commentCount = commentCount;
                }

                public int getFavoriteCount() {
                    return favoriteCount;
                }

                public void setFavoriteCount(int favoriteCount) {
                    this.favoriteCount = favoriteCount;
                }

                public int getFeedCount() {
                    return feedCount;
                }

                public void setFeedCount(int feedCount) {
                    this.feedCount = feedCount;
                }

                public boolean isHasFollow() {
                    return hasFollow;
                }

                public void setHasFollow(boolean hasFollow) {
                    this.hasFollow = hasFollow;
                }
            }

            public static class UgcBean {
                private int likeCount;
                private int shareCount;
                private int commentCount;
                private boolean hasFavorite;
                private boolean hasLiked;
                private boolean hasdiss;
                private boolean hasDissed;

                public int getLikeCount() {
                    return likeCount;
                }

                public void setLikeCount(int likeCount) {
                    this.likeCount = likeCount;
                }

                public int getShareCount() {
                    return shareCount;
                }

                public void setShareCount(int shareCount) {
                    this.shareCount = shareCount;
                }

                public int getCommentCount() {
                    return commentCount;
                }

                public void setCommentCount(int commentCount) {
                    this.commentCount = commentCount;
                }

                public boolean isHasFavorite() {
                    return hasFavorite;
                }

                public void setHasFavorite(boolean hasFavorite) {
                    this.hasFavorite = hasFavorite;
                }

                public boolean isHasLiked() {
                    return hasLiked;
                }

                public void setHasLiked(boolean hasLiked) {
                    this.hasLiked = hasLiked;
                }

                public boolean isHasdiss() {
                    return hasdiss;
                }

                public void setHasdiss(boolean hasdiss) {
                    this.hasdiss = hasdiss;
                }

                public boolean isHasDissed() {
                    return hasDissed;
                }

                public void setHasDissed(boolean hasDissed) {
                    this.hasDissed = hasDissed;
                }
            }
        }
    }
}
