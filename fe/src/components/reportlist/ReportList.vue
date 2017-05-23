<template>
  <div class="report-list-container">
    <top-nav activeIndex="0"></top-nav>
    <div class="table-container">
      <el-table
        :data="reportList"
        border
        style="width: 100%">
        <el-table-column
          prop="stuClass"
          label="班级">
        </el-table-column>

        <el-table-column
          prop="stuId"
          label="学号">
        </el-table-column>

        <el-table-column
          prop="stuName"
          label="姓名">
        </el-table-column>

        <el-table-column
          label="操作"
          width="100">
          <template scope="scope">
            <el-button v-on:click="handleTableClick(scope.row)" type="text" size="small">查看</el-button>
            <!--<el-button type="text" size="small">编辑</el-button>-->
          </template>
        </el-table-column>

      </el-table>
    </div>
  </div>
</template>

<script>
  import API from '../../config/request';
  import TopNav from '../common/TopNav.vue';
  export default {
    data() {
      return {
        reportList: []
      }
    },
    created() {
      this.loadData();
    },
    methods: {
      loadData() {
        this.$http.get(API.reportList(this.$route.params.id)).then(
          (res) => {
            console.log(res.data)
            this.reportList = res.data.reportBeanList;
          }
        )
      },
      handleTableClick (row) {
        this.$router.push({name: 'Detail', params: {stuid: row.stuId, tplid: this.$route.params.id}})
      },
    },
    components: {
      TopNav
    }
  }
</script>

<style lang="less">
  .report-list-container {

    .table-container {
      margin: 20px 15%;
    }
  }

</style>
