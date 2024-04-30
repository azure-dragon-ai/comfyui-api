<template>
  <div class="app-container home">
    <el-row :gutter="20">
      <el-col :xs="24" :sm="24" :md="24" :lg="24">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>更新日志</span>
          </div>
          <el-collapse accordion>
            <el-collapse-item title="v3.8.7 - 2023-12-08">
              <ol>
                <li>操作日志记录部门名称</li>
                <li>全局数据存储用户编号</li>
                <li>新增编程式判断资源访问权限</li>
                <li>操作日志列表新增IP地址查询</li>
                <li>定时任务新增页去除状态选项</li>
                <li>代码生成支持选择前端模板类型</li>
                <li>显隐列组件支持复选框弹出类型</li>
                <li>通用排序属性orderBy参数限制长度</li>
                <li>Excel自定义数据处理器增加单元格/工作簿对象</li>
                <li>升级oshi到最新版本6.4.8</li>
                <li>升级druid到最新版本1.2.20</li>
                <li>升级fastjson到最新版2.0.43</li>
                <li>升级pagehelper到最新版1.4.7</li>
                <li>升级commons.io到最新版本2.13.0</li>
                <li>升级element-ui到最新版本2.15.14</li>
                <li>修复五级路由缓存无效问题</li>
                <li>修复外链带端口出现的异常</li>
                <li>修复树模板父级编码变量错误</li>
                <li>修复字典表详情页面搜索问题</li>
                <li>修复内链iframe没有传递参数问题</li>
                <li>修复自定义字典样式不生效的问题</li>
                <li>修复字典缓存删除方法参数错误问题</li>
                <li>修复Excel导入数据临时文件无法删除问题</li>
                <li>修复未登录带参数访问成功后参数丢失问题</li>
                <li>修复HeaderSearch组件跳转query参数丢失问题</li>
                <li>修复代码生成导入后必填项与数据库不匹配问题</li>
                <li>修复Excels导入时无法获取到dictType字典值问题</li>
                <li>优化下载zip方法新增遮罩层</li>
                <li>优化头像上传参数新增文件名称</li>
                <li>优化字典标签支持自定义分隔符</li>
                <li>优化菜单管理类型为按钮状态可选</li>
                <li>优化前端防重复提交数据大小限制</li>
                <li>优化TopNav菜单没有图标svg不显示</li>
                <li>优化数字金额大写转换精度丢失问题</li>
                <li>优化富文本Editor组件检验图片格式</li>
                <li>优化页签在Firefox浏览器被遮挡的问题</li>
                <li>优化个人中心/基本资料修改时数据显示问题</li>
                <li>优化缓存监控图表支持跟随屏幕大小自适应调整</li>
                <li>其他细节优化</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v3.8.6 - 2023-06-30">
              <ol>
                <li>支持登录IP黑名单限制</li>
                <li>新增监控页面图标显示</li>
                <li>操作日志新增消耗时间属性</li>
                <li>屏蔽定时任务bean违规的字符</li>
                <li>日志管理使用索引提升查询性能</li>
                <li>日志注解支持排除指定的请求参数</li>
                <li>支持自定义隐藏属性列过滤子对象</li>
                <li>升级oshi到最新版本6.4.3</li>
                <li>升级druid到最新版本1.2.16</li>
                <li>升级fastjson到最新版2.0.34</li>
                <li>升级spring-boot到最新版本2.5.15</li>
                <li>升级element-ui到最新版本2.15.13</li>
                <li>移除apache/commons-fileupload依赖</li>
                <li>修复页面切换时布局错乱的问题</li>
                <li>修复匿名注解Anonymous空指针问题</li>
                <li>修复路由跳转被阻止时内部产生报错信息问题</li>
                <li>修复isMatchedIp的参数判断产生空指针的问题</li>
                <li>修复用户多角色数据权限可能出现权限抬升的情况</li>
                <li>修复开启TopNav后一级菜单路由参数设置无效问题</li>
                <li>修复DictTag组件value没有匹配的值时则展示value</li>
                <li>优化文件下载出现的异常</li>
                <li>优化选择图标组件高亮回显</li>
                <li>优化弹窗后导航栏偏移的问题</li>
                <li>优化修改密码日志存储明文问题</li>
                <li>优化页签栏关闭其他出现的异常问题</li>
                <li>优化页签关闭左侧选项排除首页选项</li>
                <li>优化关闭当前tab页跳转最右侧tab页</li>
                <li>优化缓存列表清除操作提示不变的问题</li>
                <li>优化字符未使用下划线不进行驼峰式处理</li>
                <li>优化用户导入更新时需获取用户编号问题</li>
                <li>优化侧边栏的平台标题与VUE_APP_TITLE保持同步</li>
                <li>优化导出Excel时设置dictType属性重复查缓存问题</li>
                <li>连接池Druid支持新的配置connectTimeout和socketTimeout</li>
                <li>其他细节优化</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v1.0.0 - 2019-10-08">
              <ol>
                <li>若依前后端分离系统正式发布</li>
              </ol>
            </el-collapse-item>
          </el-collapse>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "Index",
  data() {
    return {
      // 版本号
      version: "3.8.7"
    };
  },
  methods: {
    goTarget(href) {
      window.open(href, "_blank");
    }
  }
};
</script>

<style scoped lang="scss">
.home {
  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }
  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }
  .col-item {
    margin-bottom: 20px;
  }

  ul {
    padding: 0;
    margin: 0;
  }

  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;

  ul {
    list-style-type: none;
  }

  h4 {
    margin-top: 0px;
  }

  h2 {
    margin-top: 10px;
    font-size: 26px;
    font-weight: 100;
  }

  p {
    margin-top: 10px;

    b {
      font-weight: 700;
    }
  }

  .update-log {
    ol {
      display: block;
      list-style-type: decimal;
      margin-block-start: 1em;
      margin-block-end: 1em;
      margin-inline-start: 0;
      margin-inline-end: 0;
      padding-inline-start: 40px;
    }
  }
}
</style>

