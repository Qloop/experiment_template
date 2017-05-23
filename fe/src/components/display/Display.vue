<template>
  <div>
    <top-nav activeIndex="2"></top-nav>
    <div class="display-container">

      <div class="header-area">
        <h2>请输入创建者ID</h2>
        <el-input v-model="authorId"></el-input>
        <el-button type="primary" @click="onSearch">查询</el-button>
      </div>

      <div class="table-container">
        <el-table
          :data="templateList"
          border
          style="width: 100%">
          <el-table-column
            prop="templateId"
            label="模板ID"
            width="80">
          </el-table-column>

          <el-table-column
            prop="title"
            label="实验名"
            width="280">
          </el-table-column>

          <el-table-column
            prop="createDate"
            label="创建日期">
          </el-table-column>

          <el-table-column
            label="操作"
            width="100">
            <template scope="scope">
              <el-button v-on:click="handleTableClick(scope)" type="text" size="small">查看</el-button>
              <!--<el-button type="text" size="small">编辑</el-button>-->
            </template>
          </el-table-column>

        </el-table>
      </div>

    </div>
  </div>
</template>

<script>
  import TopNav from '../common/TopNav.vue';
  import API from '../../config/request';
  export default {
    data() {
      return {
        authorId: '',
        templateList: []
      }
    },
    created() {
    },
    methods: {
      loadData() {
        this.$http.get(API.templateList + '?author=' + this.authorId).then(
          (res) => {
            console.log(res.data);
            this.templateList = res.data.templateBeanList;
          }
        )
      },
      onSearch() {
        this.loadData();
      },
      handleTableClick(id) {
          console.log(id)
//        this.$router.push('/detail', )
      }
    },
    components: {
      TopNav
    }
  }
</script>

<style lang="less" scoped>
  .display-container {
    margin: 0 15%;
    text-align: center;


    .header-area {
      overflow: hidden;

      h2 {
        margin-top: 10px;
      }

      .el-input {
        margin-top: 10px;
        width: 30%;
      }
    }

    .table-container {
      margin-top: 20px;
    }
  }
</style>
