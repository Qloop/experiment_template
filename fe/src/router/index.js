import Vue from 'vue'
import Router from 'vue-router'
import Create from '../components/create/Create.vue'
import Display from '../components/display/Display.vue'
import Report from '../components/report/Report.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/create',
      name: 'Create',
      component: Create
    },
    {
      path: '/display',
      name: 'Display',
      component: Display
    },
    {
      path: '/report/:id',
      name: 'Report',
      component: Report
    }
  ]
})
