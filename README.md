# experiment_template
实验报告模板

## 接口

- 老师创建模版
  /create
  参数:  json数据  格式看Template (id不用传)
  返回: Map<String, String>   "result"     "templateId"

- 老师查看所创建的所有模版list
	/template_list
	参数: authorId 老师的身份Id
	返回: json数据 格式看TemplateListDto

- 模版显示:
	- 学生看到的模版
	  /display 
	  参数: 实验模版ID(long)
	  返回: json数据 具体看TemplateDto

	- 获取填写某个模板的所有学生的id name class
	  /get_stu_info
	  参数: templateId
	  返回: json 格式看 ReportListDto


	- 老师查看学生的实验报告
	  /teacher_watch
	  参数: templateId, stuId  (long)
	  返回: json数据 格式见StuReportDto

- 学生实验报告提交:
  /submit_imgs
  参数: "imgs" 图片文件(一个或多个)  "templateId" 模版ID(long)
  返回: json数据  具体看ImageUrlsDto.class
  传完图片后收到图片的 保存地址(String) 之后提交报告要包含这个 地址 （放到"imgs字段"）
  /submit_report
  参数: json数据 格式看StuReport (id不用传)
  返回: Map<String, String> "result"  "stuReportId"
