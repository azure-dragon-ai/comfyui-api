<template>
    <!-- 页面全局配置 -->
    <view class="pageconfig">
        <!--vuetop-->
        <view class="toptitle1  cu-bar bg-" style="min-height: 45px;">
            <view class="action">
            </view>
            <view class="content text-black">AI绘画</view>
        </view>
        <view style="position:relative;" class="banner2   ">
            <swiper :current="swiperCurrent2" autoplay="true" @change="swiperChange2" style="height:300rpx;">
                <swiper-item class="u-swiper-item" v-for="(item, index2) in label2List" :key="index2">
                    <view class="u-list-image-wrap">
                        <image class="u-swiper-image" :src="item.image"></image>
                    </view>
                </swiper-item>
            </swiper>
            <view class="u-swiper-indicator flex justify-center" :style="{width:  '100%',bottom:  '0px',padding: '24rpx'}">
                <block>
                    <view class="u-indicator-item-number">{{ swiperCurrent2 + 1 }}/{{ label2List.length }}</view>
                </block>
            </view>
        </view>
        <view class="notice3   ">
            <uni-notice-bar color="#E62227" show-icon scrollable text="uni-app 版正式发布，开发一次，同时发布iOS、Android、H5、微信小程序、支付宝小程序、百度小程序、头条小程序等7大平台。" />
        </view>
        <view class="   gongge4 1   response ">
            <view class=" cu-list grid col-3 no-border">
                <view class=" cu-item padding " v-for="(item, index) in label4List" :class="['bg-' + item.zibgcolor]" :key="index">
                    <view>
                        <image v-if="item.imgtype !=2" :src="item.pic" class="round" mode="heightFix" style="width: auto;height:70rpx;line-height:0rpx"></image>
                        <view v-if="item.imgtype ==2" :class="['' + item.iconname,'text-' + item.iconcolor]" style="font-size: 70rpx;margin-top: 0rpx;"></view>
                        <view v-if="item.openjiao && item.jiaoname" :style="{'backgroundColor':item.jiaobgcolor?item.jiaobgcolor: 'red','padding':item.neidistance? item.neidistance*2+'rpx':'' }" class=" cu-tag badge">{{item.jiaoname}}</view>
                    </view>
                    <text style="font-size: unset;color: unset;margin-top:4rpx;">{{item.name}}</text>
                </view>
            </view>
        </view>


        <!--vuebottom-->
    </view>
</template>

<script>
    import Vue from 'vue'
    export default {
        data() {
            return {
                swiperCurrent2: 0,
                /**single**/

                label2List: [{
                    "apiimg": "",
                    "evtform": [],
                    "event": "",
                    "title": "昨夜星辰昨夜风，画楼西畔桂堂东",
                    "image": "https://shitangsys.cntdh.net//uploads/store/comment/20230304/27c20ac3f9566d77517f3365fe08682a.jpg",
                    "pic": "https://shitangsys.cntdh.net//uploads/store/comment/20230304/27c20ac3f9566d77517f3365fe08682a.jpg"
                }, {
                    "apiimg": "",
                    "evtform": [],
                    "event": "",
                    "title": "身无彩凤双飞翼，心有灵犀一点通",
                    "image": "https://shitangsys.cntdh.net//uploads/store/comment/20230304/4ea7e37b68ed1b14230f7f2b5d343124.jpg",
                    "pic": "https://shitangsys.cntdh.net//uploads/store/comment/20230304/4ea7e37b68ed1b14230f7f2b5d343124.jpg"
                }],
                /**vuejs**/
                label4List: [{
                    "name": "环球美食",
                    "imgtype": 2,
                    "iconcolor": "black",
                    "apiimg": "",
                    "apiname": "",
                    "iconname": "cuIcon-discover",
                    "pic": "https://php.diyhey.com//uploads/store/comment/20240408/83e348a393355cbebd05f58a0746f983.png",
                    "image": "https://php.diyhey.com//uploads/store/comment/20240408/83e348a393355cbebd05f58a0746f983.png"
                }, {
                    "name": "个护美妆",
                    "imgtype": 2,
                    "apiimg": "",
                    "apiname": "",
                    "iconcolor": "black",
                    "iconname": "cuIcon-like",
                    "pic": "https://shitangsys.cntdh.net//uploads/store/comment/20220426/879d742839d0047baafbb465f9b3ad98.png"
                }, {
                    "name": "营养保健",
                    "imgtype": 2,
                    "apiimg": "",
                    "apiname": "",
                    "iconcolor": "black",
                    "iconname": "cuIcon-shop",
                    "pic": "https://shitangsys.cntdh.net//uploads/store/comment/20220426/28c860417000b58346fbbb935c6243c1.png"
                }, {
                    "name": "家居厨卫",
                    "imgtype": 2,
                    "apiimg": "",
                    "apiname": "",
                    "iconcolor": "black",
                    "iconname": "cuIcon-samefill",
                    "pic": "https://shitangsys.cntdh.net//uploads/store/comment/20220426/d5d01475c210e46c357cf3ffaea47535.png"
                }, {
                    "name": "速食生鲜",
                    "imgtype": 2,
                    "apiimg": "",
                    "apiname": "",
                    "iconcolor": "black",
                    "iconname": "cuIcon-evaluate",
                    "pic": "https://shitangsys.cntdh.net//uploads/store/comment/20220426/0fc1b1545ee701a807c4d7794cc0ec45.png",
                    "url": "/pages/users/user_goods_collection/index"
                }, {
                    "name": "爱护环境",
                    "imgtype": 2,
                    "iconcolor": "black",
                    "apiimg": "",
                    "apiname": "",
                    "iconname": "cuIcon-deliver",
                    "pic": "https://shitangsys.cntdh.net//uploads/store/comment/20220426/4e227336b9eeb33a2bb3c4b5f912c1af.png",
                    "url": "/pages/users/user_address_list/index"
                }, {
                    "name": "母婴用品",
                    "imgtype": 2,
                    "iconcolor": "black",
                    "apiimg": "",
                    "apiname": "",
                    "iconname": "cuIcon-weibo",
                    "pic": "https://shitangsys.cntdh.net//uploads/store/comment/20220426/a0e089eae12fefc254284f6bad3b8a03.png",
                    "url": "/pages/users/user_money/index"
                }, {
                    "name": "环球美食",
                    "imgtype": 2,
                    "iconcolor": "black",
                    "apiimg": "",
                    "apiname": "",
                    "iconname": "cuIcon-present",
                    "pic": "https://shitangsys.cntdh.net//uploads/store/comment/20220426/fd2f58bb7251c6e5df08e8d05a23463b.png"
                }],
                /**vuejs**/


            };
        },
        onLoad() {


        },
        methods: {


            /**
             *          $vuetag = "";
             *          $vuecss = "";
             *          $vuejs = "";
             *
             */

            swiperChange2(e) {
                this.swiperCurrent2 = e.detail.current;
            },
            //获取数据

        }
    }
</script>

<style lang="less">
    /**
 *
 此处必须引用colorui样式,并放入根目录，css样式可以这样写
	@import "colorui/main.css";
	@import "colorui/icon.css";

 如需要引用colorui到全局，
 需要在App.vue 引入
 	@import "colorui/main.css";
	@import "colorui/icon.css";
 *
 */




    /**本页全局配置的代码**/
    .pageconfig {
        width: 100%;
        overflow: hidden;
        overflow-y: scroll;
        height: 100vh;
    }



    /**pagedomcss**/


    .toptitle1 {
        width: 100%;
    }

    /* 常用轮播图 css*/
    .u-swiper-image {
        width: 100%;
        will-change: transform;
        height: 100%;
        /* #ifndef APP-NVUE */
        display: block;
        /* #endif */
        /* #ifdef H5 */
        pointer-events: none;
        /* #endif */
    }

    .u-swiper-indicator {
        padding: 0 24rpx;
        position: absolute;
        z-index: 1;
    }

    .u-indicator-item-rect {
        width: 26rpx;
        height: 8rpx;
        margin: 0 6rpx;
        transition: all 0.5s;
        background-color: rgba(0, 0, 0, 0.3);
    }

    .u-indicator-item-rect-active {
        background-color: rgba(255, 255, 255, 0.8);
    }

    .u-indicator-item-dot {
        width: 14rpx;
        height: 14rpx;
        margin: 0 6rpx;
        border-radius: 20rpx;
        transition: all 0.5s;
        background-color: rgba(0, 0, 0, 0.3);
    }

    .u-indicator-item-dot-active {
        background-color: rgba(255, 255, 255, 0.8);
    }

    .u-indicator-item-round {
        width: 14rpx;
        height: 14rpx;
        margin: 0 6rpx;
        border-radius: 20rpx;
        transition: all 0.5s;
        background-color: rgba(0, 0, 0, 0.3);
    }

    .u-indicator-item-round-active {
        width: 34rpx;
        background-color: rgba(255, 255, 255, 0.8);
    }

    .u-indicator-item-number {
        padding: 6rpx 16rpx;
        line-height: 1;
        background-color: rgba(0, 0, 0, 0.3);
        border-radius: 100rpx;
        font-size: 26rpx;
        color: rgba(255, 255, 255, 0.8);
    }

    .u-list-scale {
        transform-origin: center center;
    }

    .u-list-image-wrap {
        width: 100%;
        height: 100%;
        flex: 1;
        transition: all 0.5s;
        overflow: hidden;
        box-sizing: content-box;
        position: relative;
    }

    .u-swiper-title {
        position: absolute;
        background-color: rgba(0, 0, 0, 0.3);
        bottom: 0;
        left: 0;
        width: 100%;
        font-size: 28rpx;
        padding: 12rpx 24rpx;
        color: rgba(255, 255, 255, 0.9);
    }

    .u-swiper-item {
        overflow: hidden;
        align-items: center;
    }

    .banner2 {
        width: 100%;
    }

    .notice3 {
        width: 100%;
    }

    .gongge4 {
        width: 100%;
    }
</style>