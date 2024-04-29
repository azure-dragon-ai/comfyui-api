<template>
    <!-- 页面全局配置 -->
    <view class="pageconfig">
        <!--vuetop-->
        <view style="position:relative;" class="banner1   ">
            <swiper :current="swiperCurrent1" autoplay="true" @change="swiperChange1" style="height:300rpx;">
                <swiper-item class="u-swiper-item" v-for="(item, index1) in label1List" :key="index1">
                    <view class="u-list-image-wrap">
                        <image class="u-swiper-image" :src="item.image"></image>
                    </view>
                </swiper-item>
            </swiper>
            <view class="u-swiper-indicator flex justify-center" :style="{width:  '100%',bottom:  '0px',padding: '24rpx'}">
                <block>
                    <view class="u-indicator-item-number">{{ swiperCurrent1 + 1 }}/{{ label1List.length }}</view>
                </block>
            </view>
        </view>
        <view class="notice2   ">
            <uni-notice-bar color="#E62227" show-icon scrollable text="uni-app 版正式发布，开发一次，同时发布iOS、Android、H5、微信小程序、支付宝小程序、百度小程序、头条小程序等7大平台。" />
        </view>
        <view class="   gongge3 1   response ">
            <view class=" cu-list grid col-4 no-border">
                <view class=" cu-item padding-xs " v-for="(item, index) in label3List" :class="['bg-' + item.zibgcolor]" :key="index">
                    <view>
                        <image v-if="item.imgtype !=2" :src="item.pic" class="round" mode="heightFix" style="width: auto;height:70rpx;line-height:0rpx"></image>
                        <view v-if="item.imgtype ==2" :class="['' + item.iconname,'text-' + item.iconcolor]" style="font-size: 70rpx;margin-top: 0rpx;"></view>
                        <view v-if="item.openjiao && item.jiaoname" :style="{'backgroundColor':item.jiaobgcolor?item.jiaobgcolor: 'red','padding':item.neidistance? item.neidistance*2+'rpx':'' }" class=" cu-tag badge">{{item.jiaoname}}</view>
                    </view>
                    <text style="font-size: unset;color: unset;margin-top:4rpx;">{{item.name}}</text>
                </view>
            </view>
        </view>

        <view style="height: 98rpx;"></view>
    </view>
</template>

<script>
    import Vue from 'vue'
    export default {
        data() {
            return {
                swiperCurrent1: 0,
                /**single**/

                label1List: [{
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
                label3List: [{
                    "name": "环球美",
                    "imgtype": 1,
                    "iconcolor": "black",
                    "apiimg": "",
                    "apiname": "",
                    "iconname": "cuIcon-home",
                    "pic": "https://shitangsys.cntdh.net//uploads/store/comment/20220426/fd2f58bb7251c6e5df08e8d05a23463b.png"
                }, {
                    "name": "个护美妆",
                    "imgtype": 1,
                    "apiimg": "",
                    "apiname": "",
                    "iconcolor": "black",
                    "iconname": "home",
                    "pic": "https://shitangsys.cntdh.net//uploads/store/comment/20220426/879d742839d0047baafbb465f9b3ad98.png"
                }, {
                    "name": "营养保健",
                    "imgtype": 1,
                    "apiimg": "",
                    "apiname": "",
                    "iconcolor": "black",
                    "iconname": "cuIcon-home",
                    "pic": "https://shitangsys.cntdh.net//uploads/store/comment/20220426/28c860417000b58346fbbb935c6243c1.png"
                }, {
                    "name": "家居厨卫",
                    "imgtype": 1,
                    "apiimg": "",
                    "apiname": "",
                    "iconcolor": "black",
                    "iconname": "home",
                    "pic": "https://shitangsys.cntdh.net//uploads/store/comment/20220426/d5d01475c210e46c357cf3ffaea47535.png"
                }, {
                    "name": "速食生鲜",
                    "imgtype": 1,
                    "apiimg": "",
                    "apiname": "",
                    "iconcolor": "black",
                    "iconname": "home",
                    "pic": "https://shitangsys.cntdh.net//uploads/store/comment/20220426/0fc1b1545ee701a807c4d7794cc0ec45.png",
                    "url": "/pages/users/user_goods_collection/index"
                }, {
                    "name": "爱护环境",
                    "imgtype": 1,
                    "iconcolor": "black",
                    "apiimg": "",
                    "apiname": "",
                    "iconname": "home",
                    "pic": "https://shitangsys.cntdh.net//uploads/store/comment/20220426/4e227336b9eeb33a2bb3c4b5f912c1af.png",
                    "url": "/pages/users/user_address_list/index"
                }, {
                    "name": "母婴用品",
                    "imgtype": 1,
                    "iconcolor": "black",
                    "apiimg": "",
                    "apiname": "",
                    "iconname": "home",
                    "pic": "https://shitangsys.cntdh.net//uploads/store/comment/20220426/a0e089eae12fefc254284f6bad3b8a03.png",
                    "url": "/pages/users/user_money/index"
                }],
                /**vuejs**/
                label4List: [{
                    "name": "首页1",
                    "event": "",
                    "imgtype": 2,
                    "iconcolor": "black",
                    "iconname": "cuIcon-home",
                    "pic": "https://shitangsys.cntdh.net//uploads/store/comment/20220426/d5d01475c210e46c357cf3ffaea47535.png",
                    "url": "",
                    "image": "https://shitangsys.cntdh.net//uploads/store/comment/20220426/d5d01475c210e46c357cf3ffaea47535.png"
                }, {
                    "name": "分类",
                    "event": "",
                    "imgtype": 2,
                    "iconcolor": "blue",
                    "iconname": "cuIcon-sort",
                    "pic": "https://shitangsys.cntdh.net//uploads/store/comment/20220426/28c860417000b58346fbbb935c6243c1.png",
                    "url": ""
                }, {
                    "name": "购物车",
                    "imgtype": 2,
                    "iconcolor": "grey",
                    "iconname": "cuIcon-cart",
                    "pic": "https://shitangsys.cntdh.net//uploads/store/comment/20220426/879d742839d0047baafbb465f9b3ad98.png",
                    "url": ""
                }, {
                    "name": "我的",
                    "event": "",
                    "imgtype": 2,
                    "iconcolor": "red",
                    "iconname": "cuIcon-my",
                    "pic": "https://shitangsys.cntdh.net//uploads/store/comment/20220426/d5d01475c210e46c357cf3ffaea47535.png",
                    "url": ""
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

            swiperChange1(e) {
                this.swiperCurrent1 = e.detail.current;
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
        background-color: #ffffff;
        height: 100vh;
    }



    /**pagedomcss**/


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

    .banner1 {
        width: 100%;
    }

    .notice2 {
        width: 100%;
    }

    .gongge3 {
        width: 100%;
    }

    .dibubtn4 {
        width: 100%;
    }
</style>