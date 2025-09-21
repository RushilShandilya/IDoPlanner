import { defineConfig } from 'vite'

export default defineConfig({
  root: 'frontend',
  server: {
    port: 3000,
    open: '/pages/index.html'
  },
  build: {
    outDir: '../dist'
  }
})