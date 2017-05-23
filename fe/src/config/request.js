/**
 * Created by lhy95 on 2017/5/21.
 */

const baseUrl = 'http://118.89.112.50:8082';

const API = {
  create: baseUrl + '/create',
  display(reportId){
    return baseUrl + '/display/?id=' + reportId
  },
  templateList: baseUrl + '/template_list',
  submitImages: baseUrl + '/submit_imgs',
  submitReport: baseUrl + '/submit_report',
  reportList(templateId){return baseUrl + '/get_stu_info?templateId=' + templateId}
};

module.exports = API;
