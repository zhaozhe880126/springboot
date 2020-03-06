<template>
  <div class="homepage-hero-module">
    <div id="userLayout" :class="['user-layout-wrapper', device]">
      <div class="container">
        <route-view></route-view>
      </div>
    </div>
    <div class="video-container">
      <div :style="fixStyle" class="filter"></div>
      <video :style="fixStyle" autoplay loop class="fillWidth" v-on:canplay="canplay">
        <source src="../../assets/coverr.mp4" type="video/mp4"/>
        Your browser does not support the video tag. I suggest you upgrade your browser.
        <source src="static/cover/WEBM/Yellow-Cars.webm" type="video/webm"/>
        Your browser does not support the video tag. I suggest you upgrade your browser.
      </video>
      <div class="poster hidden" v-if="!vedioCanPlay">
        <img :style="fixStyle" src="../../assets/coverr.jpg" alt="">
      </div>
    </div>
  </div>

<!--  <div id="userLayout" :class="['user-layout-wrapper', device]">
    <div class="container">
      <div class="top">
        <div class="header">
          <a href="/">
            <img src="~@/assets/logo.svg" class="logo" alt="logo">
            <span class="title">Jeecg Boot</span>
          </a>
        </div>
        <div class="desc">
        ******************
        </div>
      </div>

      <route-view></route-view>

     &lt;!&ndash; <div class="footer">
        <div class="links">
          <a href="" target="_blank">帮助</a>
          <a href="" target="_blank">隐私</a>
          <a href="" target="_blank">条款</a>
        </div>
        <div class="copyright">
          Copyright &copy; 2020 <a href="" target="_blank"></a>
        </div>
      </div>&ndash;&gt;
    </div>
  </div>-->
</template>

<script>
  import RouteView from "@/components/layouts/RouteView"
  import { mixinDevice } from '@/utils/mixin.js'

  export default {
    name: "UserLayout",
    components: { RouteView },
    mixins: [mixinDevice],
    data () {
      return {
          vedioCanPlay: false,
          fixStyle: ''
      }
    },
    methods: {
      canplay() {
          this.vedioCanPlay = true
      }
    },
    mounted () {
        window.onresize = () => {
            const windowWidth = document.body.clientWidth
            const windowHeight = document.body.clientHeight
            const windowAspectRatio = windowHeight / windowWidth
            let videoWidth
            let videoHeight
            if (windowAspectRatio < 0.5625) {
                videoWidth = windowWidth
                videoHeight = videoWidth * 0.5625
                this.fixStyle = {
                    height: windowWidth * 0.5625 + 'px',
                    width: windowWidth + 'px',
                    'margin-bottom': (windowHeight - videoHeight) / 2 + 'px',
                    'margin-left': 'initial'
                }
            } else {
                videoHeight = windowHeight
                videoWidth = videoHeight / 0.5625
                this.fixStyle = {
                    height: windowHeight + 'px',
                    width: windowHeight / 0.5625 + 'px',
                    'margin-left': (windowWidth - videoWidth) / 2 + 'px',
                    'margin-bottom': 'initial'
                }
            }
        }
      document.body.classList.add('userLayout')
    },
    beforeDestroy () {
      document.body.classList.remove('userLayout')
    },
  }
</script>

<style lang="scss" scoped>
  #userLayout.user-layout-wrapper {
    height: 100%;

    &.mobile {
      .container {
        .main {
          max-width: 368px;
          width: 98%;
        }
      }
    }

    .container {
      width: 100%;
      min-height: 100%;
     // background: #f0f2f5 url(~@/assets/background.svg) no-repeat 50%;
     // background-size: 100%;
      padding: 110px 0 144px;
      position: relative;
      display: flex;
      flex-direction: column;
      justify-content: center;

      position: absolute;
      z-index: 100;


      a {
        text-decoration: none;
      }

      .top {
        text-align: center;

        .header {
          height: 44px;
          line-height: 44px;

          .badge {
            position: absolute;
            display: inline-block;
            line-height: 1;
            vertical-align: middle;
            margin-left: -12px;
            margin-top: -10px;
            opacity: 0.8;
          }

          .logo {
            height: 44px;
            vertical-align: top;
            margin-right: 16px;
            border-style: none;
          }

          .title {
            font-size: 33px;
            color: rgba(0, 0, 0, .85);
            font-family: "Chinese Quote", -apple-system, BlinkMacSystemFont, "Segoe UI", "PingFang SC", "Hiragino Sans GB", "Microsoft YaHei", "Helvetica Neue", Helvetica, Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol";
            font-weight: 600;
            position: relative;
            top: 2px;
          }
        }
        .desc {
          font-size: 14px;
          color: rgba(0, 0, 0, 0.45);
          margin-top: 12px;
          margin-bottom: 40px;
        }
      }

      .main {
        min-width: 260px;
        width: 368px;
        margin: 0 auto;
      }

      .footer {
        position: absolute;
        width: 100%;
        bottom: 0;
        padding: 0 16px;
        margin: 48px 0 24px;
        text-align: center;

        .links {
          margin-bottom: 8px;
          font-size: 14px;
          a {
            color: rgba(0, 0, 0, 0.45);
            transition: all 0.3s;
            &:not(:last-child) {
              margin-right: 40px;
            }
          }
        }
        .copyright {
          color: rgba(0, 0, 0, 0.45);
          font-size: 14px;
        }
      }
    }
  }
</style>