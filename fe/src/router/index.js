import Vue from 'vue'
import Router from 'vue-router'
import Create from '../components/create/Create.vue'
import Display from '../components/display/Display.vue'
import Report from '../components/report/Report.vue'
import Detail from '../components/detail/Detail.vue'
import ReportList from '../components/reportlist/ReportList.vue';

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
    },
    {
      path: '/detail/stuid/:stuid/tpl/:tplid',
      name: 'Detail',
      component: Detail
    },
    {
      // 根据模板ID查该模板提交记录
      path: '/reportlist/:id',
      name: 'ReportList',
      component: ReportList
    }
  ]
})
