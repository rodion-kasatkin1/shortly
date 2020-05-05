import Vue from 'vue'

import VueResource from 'vue-resource'
Vue.use(VueResource)

import App from 'vue/App.vue'
import '@babel/polyfill'

import Vuex from 'vuex'
Vue.use(Vuex)
import store from 'store/vuexstore';

import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css'
import router from 'router/router'

Vue.use(Vuetify, {
    theme: {
        primary: '#C5E1A5',
        secondary: '#b0bec5',
        accent: '#29cf00',
        errorMess: '#b71c1c'
    }
})

new Vue({
    el: '#app',
    store,
    router,
    vuetify: new Vuetify({}),
    render: a => a(App)
})