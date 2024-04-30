import request from '@/utils/request'

// 查询AI生成工作流列表
export function listWorkflow(query) {
  return request({
    url: '/comfyui/workflow/list',
    method: 'get',
    params: query
  })
}

// 查询AI生成工作流详细
export function getWorkflow(id) {
  return request({
    url: '/comfyui/workflow/' + id,
    method: 'get'
  })
}

// 新增AI生成工作流
export function addWorkflow(data) {
  return request({
    url: '/comfyui/workflow',
    method: 'post',
    data: data
  })
}

// 修改AI生成工作流
export function updateWorkflow(data) {
  return request({
    url: '/comfyui/workflow',
    method: 'put',
    data: data
  })
}

// 删除AI生成工作流
export function delWorkflow(id) {
  return request({
    url: '/comfyui/workflow/' + id,
    method: 'delete'
  })
}
