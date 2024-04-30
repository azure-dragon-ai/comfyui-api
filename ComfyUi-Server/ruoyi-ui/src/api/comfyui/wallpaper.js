import request from '@/utils/request'

// 查询AI附件列表
export function listWallpaper(query) {
  return request({
    url: '/comfyui/wallpaper/list',
    method: 'get',
    params: query
  })
}

// 查询AI附件详细
export function getWallpaper(id) {
  return request({
    url: '/comfyui/wallpaper/' + id,
    method: 'get'
  })
}

// 新增AI附件
export function addWallpaper(data) {
  return request({
    url: '/comfyui/wallpaper',
    method: 'post',
    data: data
  })
}

// 修改AI附件
export function updateWallpaper(data) {
  return request({
    url: '/comfyui/wallpaper',
    method: 'put',
    data: data
  })
}

// 删除AI附件
export function delWallpaper(id) {
  return request({
    url: '/comfyui/wallpaper/' + id,
    method: 'delete'
  })
}
