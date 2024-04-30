import request from '@/utils/request'

// 查询AI生产任务列表
export function listTask(query) {
  return request({
    url: '/comfyui/task/list',
    method: 'get',
    params: query
  })
}

// 查询AI生产任务详细
export function getTask(id) {
  return request({
    url: '/comfyui/task/' + id,
    method: 'get'
  })
}

// 新增AI生产任务
export function addTask(data) {
  return request({
    url: '/comfyui/task',
    method: 'post',
    data: data
  })
}

// 修改AI生产任务
export function updateTask(data) {
  return request({
    url: '/comfyui/task',
    method: 'put',
    data: data
  })
}

// 删除AI生产任务
export function delTask(id) {
  return request({
    url: '/comfyui/task/' + id,
    method: 'delete'
  })
}
