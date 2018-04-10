var news = new Vue({
    el: "#news",
    data: {
        left: {
            inform: {
                text: "通知公告",
                link: "new.html"
            },
            flash: {
                text: "要闻快讯",
                link: "new-flash.html"
            },
            media: {
                text: "媒体报道",
                link: "new-media.html"
            },
            student: {
                text: "学生活动",
                link: "new-student.html"
            }
        },
        right: {
            inform: {
                show: {

                },
                list: [
                    {
                        title: "网络教育2017年秋季重考报名通知",
                        time: "2018-04-05",
                        link: "new-inform1.html",
                    },
                    {
                        title: "网络教育(专本科）2017年春季课程期末考试安排",
                        time: "2018-04-05",
                        link: "",
                    },
                    {
                        title: "转：上海交通大学2017年秋季网络教育（专本科）报名时间截止的通知",
                        time: "2018-04-05",
                        link: "",
                    },
                    {
                        title: "关于上海交通大学网络教育2017学年春季学期入学考试通知",
                        time: "2018-04-05",
                        link: "",
                    },
                    {
                        title: "研究生院关于2016-2017学年春季学期研究生注册和上课的通知",
                        time: "2018-04-05",
                        link: "",
                    }
                ]
            }
        },
        navList: {
            page: [
                {
                    No_: "1",
                    list: ""
                },
                {
                    No_: "2",
                    list: ""
                },
                {
                    No_: "3",
                    list: ""
                },
            ]
        },
    },
    methods: {
        skipPage: function (params) {
            console.log(params.toElement.innerText.trim() == this.navList.page[0].No_)
            params.path[1].className += ' active';
            console.log(params.path[1])
            console.log(params)
            for (let i = 0; i < this.navList.page.length; i++) {
                this.navList.page[i]
            }
        }
    }
});

// $.ajax({
//     url:"http://47.106.123.115/xpject-web/admin/sys/banner/seleList",
//     data:"",
//     success: function (data) {     
//         if (data.status==0) {
//             return console.log(data.msg);
//         }
//     },
// });
