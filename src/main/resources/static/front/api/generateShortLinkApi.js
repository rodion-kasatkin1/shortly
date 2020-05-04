import Vue from 'vue'
import VueResource from 'vue-resource'
Vue.use(VueResource)

const apiGenerateShortlink = Vue.resource('api/generate')
export default{
    generateLink:full=>apiGenerateShortlink.save(full),
}

// const apiAdvert = Vue.resource('/api/advertisments/{id}')
// const apiAuth = Vue.resource('/api/auth')
// const apiRegistration = Vue.resource('/api/auth/reg')
// const apiCourses = Vue.resource('/api/courses/{id}')
// const apiFiles = Vue.resource('/api/uploadFile')
// const apiVideo = Vue.resource('/api/addVideoCourse')
// const apiComment = Vue.resource('/api/comments')
// const apiProfile = Vue.resource('/api/profile')
// const apiGetAllStudents = Vue.resource('/api/profile/all')
// const apiPublicProfile = Vue.resource('/api/profile/public/{id}')
// const apiEvent = Vue.resource('/api/events/{id}')
// const apiAddCourseToUser = Vue.resource('/api/userAction/addCourse/{id}')
// const apiUploadUserPic = Vue.resource('/api/profile/updateAvatar')
// const apiChat = Vue.resource('/api/chat')
// const apiChatFile = Vue.resource('/api/chat/file')
// const apiRemoveCourseFromUserList = Vue.resource('/api/userAction/course/{id}')
// const apiUpdateMark = Vue.resource("/api/userAction/updatemark")
// const apiGetFullCourses = Vue.resource('/api/courses/full')
// export default {
//     addAdvert: advertisment => apiAdvert.save({}, advertisment),
//     updateAdvert: advertisment => apiAdvert.updateAdvert({id: advertisment.id}, advertisment),
//     removeAdvert: id => apiAdvert.removeAdvert({id}),
//     getAllCourses: () => apiCourses.get({}),
//     login: user => apiAuth.save({}, user),
//     logOutUser: (userid) => apiAuth.delete(userid),
//     updateProfile: () => apiProfile.get(),
//     getCourseById: courseId => apiCourses.get({id: courseId}),
//     uploadFile: formData => apiFiles.save(formData),
//     addVideoCourse: videoCourseDto => apiVideo.save(videoCourseDto),
//     sendComment: comment => apiComment.save(comment),
//     addNewEvent: event => apiEvent.save(event),
//     addToUserCourse: courseId => apiAddCourseToUser.save({courseId}),
//     uploadUserPic: formData => apiUploadUserPic.save(formData),
//     editUserProfile: profile => apiProfile.update(profile),
//     loadDialogsAction: () => apiChat.get(),
//     sendMessageAction: message => apiChat.save(message),
//     uploadFileAsMessage: formData => apiChatFile.save(formData),
//     updateCourse: course => apiCourses.update(course),
//     deleteFromMyCourses:id=>apiRemoveCourseFromUserList.remove({id}),
//     removeEvent:id=> apiEvent.remove({id}),
//     getPublicProfile: id=> apiPublicProfile.get({id:id}),
//     createNewCourse: course=> apiCourses.save(course),
//     changePassword:(dto)=> apiAuth.update(dto),
//     registerUser:regDto=> apiRegistration.save(regDto),
//     updateMark: mark=> apiUpdateMark.save(mark),
//     getFullCourses: ()=> apiGetFullCourses.get(),
//     getAllStudents:()=>apiGetAllStudents.get(),
// }