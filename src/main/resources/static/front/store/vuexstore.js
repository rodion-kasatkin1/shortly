//позже это файл необходимо переименовать для конкретной фичи, \
// и соответтсвенно использовать только для нее
// если нужны функции для другой фичи, то создать отдельный стор для них
import Vue from 'vue';

import Vuex from 'vuex'

Vue.use(Vuex)
import generateShortLinkApi from '../api/generateShortLinkApi'


export default new Vuex.Store({
    state: {
        feData: frontendData,
        error: null,
        shortLink: null
        /*messages: frontendData.messages,
        profile: frontendData.profile*/
    },
    getters: {
        getErrorAfterReloadPage: state => {
            if (state.feData != null) {
                return state.feData.errorMessage
            }
        }
        /*
                sortedMessages: state => state.messages.sort((a, b) => -(a.id - b.id))
        */
    },
    mutations: {
        updateShortLink(state, link) {
            state.shortLink = link;
        },
        throwErrorMessage(state, error) {
            state.error = error
        },
        invalidateErrorMessage(state) {
            
            if (state.feData != null && state.feData.errorMessage != null) {
              state.feData.errorMessage=null;
            }
          }
        /* addMessageMutation(state, message) {
             state.messages = [
                 ...state.messages, 
                 message
             ]
         },
         updateMessageMutation(state, message) {
             const updateIndex = state.messages.findIndex(item => item.id === message.id)
             state.messages = [
                 ...state.messages.slice(0, updateIndex),
                 message,
                 ...state.messages.slice(updateIndex + 1)
             ]
         },
         removeMessageMutation(state, message) {
             const deletionIndex = state.messages.findIndex(item => item.id === message.id)
             if (deletionIndex > -1) {
                 state.messages = [
                     ...state.messages.slice(0, deletionIndex),
                     ...state.messages.slice(deletionIndex + 1)
                 ]
             }
         },*/
    },
    actions: {
        generateShortLinkApi({ commit, state }, fullLink) {
            generateShortLinkApi.generateLink(fullLink).then(
                result => {
                    result.json().then(
                        data => commit('updateShortLink', data)
                    )
                }, reject => reject.json().then(error =>
                    commit('throwErrorMessage', error))
            )
        }
        /*async addMessageAction({commit, state}, message) {
            const result = await messagesApi.add(message)
            const data = await result.json()
            const index = state.messages.findIndex(item => item.id === data.id)
            if (index > -1) {
                commit('updateMessageMutation', data)
            } else {
                commit('addMessageMutation', data)
            }
        },
        async updateMessageAction({commit}, message) {
            const result = await messagesApi.update(message)
            const data = await result.json()
            commit('updateMessageMutation', data)
        },
        async removeMessageAction({commit}, message) {
            const result = await messagesApi.remove(message.id)
            if (result.ok) {
                commit('removeMessageMutation', message)
            }
        },*/
    }
})