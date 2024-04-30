<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="工作流json文件附件id
" prop="jsonAttchId">
        <el-input
          v-model="queryParams.jsonAttchId"
          placeholder="请输入工作流json文件附件id
"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="工作流api-json文件附件id" prop="apiAttchId">
        <el-input
          v-model="queryParams.apiAttchId"
          placeholder="请输入工作流api-json文件附件id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="comfyui工作流名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入comfyui工作流名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="comfyui工作流api文件的节点组" prop="nodes">
        <el-input
          v-model="queryParams.nodes"
          placeholder="请输入comfyui工作流api文件的节点组"
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
          v-hasPermi="['comfyui:workflow:add']"
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
          v-hasPermi="['comfyui:workflow:edit']"
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
          v-hasPermi="['comfyui:workflow:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['comfyui:workflow:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="workflowList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="${comment}" align="center" prop="id" />
      <el-table-column label="工作流json文件附件id
" align="center" prop="jsonAttchId" />
      <el-table-column label="工作流api-json文件附件id" align="center" prop="apiAttchId" />
      <el-table-column label="comfyui工作流名称" align="center" prop="name" />
      <el-table-column label="comfyui工作流api文件的节点组" align="center" prop="nodes" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['comfyui:workflow:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['comfyui:workflow:remove']"
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

    <!-- 添加或修改AI生成工作流对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="工作流json文件附件id
" prop="jsonAttchId">
          <el-input v-model="form.jsonAttchId" placeholder="请输入工作流json文件附件id
" />
        </el-form-item>
        <el-form-item label="工作流api-json文件附件id" prop="apiAttchId">
          <el-input v-model="form.apiAttchId" placeholder="请输入工作流api-json文件附件id" />
        </el-form-item>
        <el-form-item label="comfyui工作流名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入comfyui工作流名称" />
        </el-form-item>
        <el-form-item label="comfyui工作流api文件的节点组" prop="nodes">
          <el-input v-model="form.nodes" placeholder="请输入comfyui工作流api文件的节点组" />
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
import { listWorkflow, getWorkflow, delWorkflow, addWorkflow, updateWorkflow } from "@/api/comfyui/workflow";

export default {
  name: "Workflow",
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
      // AI生成工作流表格数据
      workflowList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        jsonAttchId: null,
        apiAttchId: null,
        name: null,
        nodes: null
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
    /** 查询AI生成工作流列表 */
    getList() {
      this.loading = true;
      listWorkflow(this.queryParams).then(response => {
        this.workflowList = response.rows;
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
        jsonAttchId: null,
        apiAttchId: null,
        name: null,
        nodes: null
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
      this.title = "添加AI生成工作流";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getWorkflow(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改AI生成工作流";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateWorkflow(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addWorkflow(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除AI生成工作流编号为"' + ids + '"的数据项？').then(function() {
        return delWorkflow(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('comfyui/workflow/export', {
        ...this.queryParams
      }, `workflow_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
