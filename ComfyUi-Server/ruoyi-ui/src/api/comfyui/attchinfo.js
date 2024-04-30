import request from '@/utils/request'

// 查询AI附件列表
export function listAttchinfo(query) {
  return request({
    url: '/comfyui/attchinfo/list',
    method: 'get',
    params: query
  })
}

// 查询AI附件详细
export function getAttchinfo(id) {
  return request({
    url: '/comfyui/attchinfo/' + id,
    method: 'get'
  })
}

// 新增AI附件
export function addAttchinfo(data) {
  return request({
    url: '/comfyui/attchinfo',
    method: 'post',
    data: data
  })
}

// 修改AI附件
export function updateAttchinfo(data) {
  return request({
    url: '/comfyui/attchinfo',
    method: 'put',
    data: data
  })
}

// 删除AI附件
export function delAttchinfo(id) {
  return request({
    url: '/comfyui/attchinfo/' + id,
    method: 'delete'
  })
}
