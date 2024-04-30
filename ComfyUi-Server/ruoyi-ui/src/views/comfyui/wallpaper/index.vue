<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="标题" prop="title">
        <el-input
          v-model="queryParams.title"
          placeholder="请输入标题"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="壁纸分辨率，比如：1920*1080" prop="resolution">
        <el-input
          v-model="queryParams.resolution"
          placeholder="请输入壁纸分辨率，比如：1920*1080"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="一个壁纸可以有多个标签，标签对应的字典【标签】，存字典value字段，多个用英文逗号间隔，比如：10,20,30
" prop="tag">
        <el-input
          v-model="queryParams.tag"
          placeholder="请输入一个壁纸可以有多个标签，标签对应的字典【标签】，存字典value字段，多个用英文逗号间隔，比如：10,20,30
"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="精确到秒" prop="createtime">
        <el-date-picker clearable
          v-model="queryParams.createtime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择精确到秒">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="缩略图附件，ai_attchinfo表的id
" prop="thumbAttchId">
        <el-input
          v-model="queryParams.thumbAttchId"
          placeholder="请输入缩略图附件，ai_attchinfo表的id
"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="原始图附件，ai_attchinfo表的id" prop="imageAttchId">
        <el-input
          v-model="queryParams.imageAttchId"
          placeholder="请输入原始图附件，ai_attchinfo表的id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['comfyui:wallpaper:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['comfyui:wallpaper:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['comfyui:wallpaper:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['comfyui:wallpaper:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="wallpaperList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="该字段唯一且自增" align="center" prop="id" />
      <el-table-column label="标题" align="center" prop="title" />
      <el-table-column label="壁纸分辨率，比如：1920*1080" align="center" prop="resolution" />
      <el-table-column label="一个壁纸可以有多个标签，标签对应的字典【标签】，存字典value字段，多个用英文逗号间隔，比如：10,20,30
" align="center" prop="tag" />
      <el-table-column label="一个壁纸只能有一个场景分类，分类对应的字典【壁纸场景分类】，存字典value字段" align="center" prop="scenesType" />
      <el-table-column label="一个壁纸只能有一个设备分类，分类对应的字典【壁纸设备分类】，存字典value字段" align="center" prop="deviceType" />
      <el-table-column label="精确到秒" align="center" prop="createtime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createtime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="缩略图附件，ai_attchinfo表的id
" align="center" prop="thumbAttchId" />
      <el-table-column label="原始图附件，ai_attchinfo表的id" align="center" prop="imageAttchId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['comfyui:wallpaper:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['comfyui:wallpaper:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改AI附件对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="标题" prop="title">
          <el-input v-model="form.title" placeholder="请输入标题" />
        </el-form-item>
        <el-form-item label="壁纸分辨率，比如：1920*1080" prop="resolution">
          <el-input v-model="form.resolution" placeholder="请输入壁纸分辨率，比如：1920*1080" />
        </el-form-item>
        <el-form-item label="一个壁纸可以有多个标签，标签对应的字典【标签】，存字典value字段，多个用英文逗号间隔，比如：10,20,30
" prop="tag">
          <el-input v-model="form.tag" placeholder="请输入一个壁纸可以有多个标签，标签对应的字典【标签】，存字典value字段，多个用英文逗号间隔，比如：10,20,30
" />
        </el-form-item>
        <el-form-item label="缩略图附件，ai_attchinfo表的id
" prop="thumbAttchId">
          <el-input v-model="form.thumbAttchId" placeholder="请输入缩略图附件，ai_attchinfo表的id
" />
        </el-form-item>
        <el-form-item label="原始图附件，ai_attchinfo表的id" prop="imageAttchId">
          <el-input v-model="form.imageAttchId" placeholder="请输入原始图附件，ai_attchinfo表的id" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listWallpaper, getWallpaper, delWallpaper, addWallpaper, updateWallpaper } from "@/api/comfyui/wallpaper";

export default {
  name: "Wallpaper",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // AI附件表格数据
      wallpaperList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        title: null,
        resolution: null,
        tag: null,
        scenesType: null,
        deviceType: null,
        createtime: null,
        thumbAttchId: null,
        imageAttchId: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询AI附件列表 */
    getList() {
      this.loading = true;
      listWallpaper(this.queryParams).then(response => {
        this.wallpaperList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        title: null,
        resolution: null,
        tag: null,
        scenesType: null,
        deviceType: null,
        createtime: null,
        thumbAttchId: null,
        imageAttchId: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加AI附件";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getWallpaper(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改AI附件";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateWallpaper(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addWallpaper(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除AI附件编号为"' + ids + '"的数据项？').then(function() {
        return delWallpaper(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('comfyui/wallpaper/export', {
        ...this.queryParams
      }, `wallpaper_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
