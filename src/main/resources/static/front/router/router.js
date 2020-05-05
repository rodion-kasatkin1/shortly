import Vue from 'vue'
import VueRouter from 'vue-router'
Vue.use(VueRouter)
import MainContant from '../vue/component/body/MainContant.vue'

const routes = [
    { path: '*', component: MainContant },

]
export default new VueRouter({
    mode: 'history',
    routes
})