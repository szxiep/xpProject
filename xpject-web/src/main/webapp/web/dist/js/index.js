var home = new Vue({
    el: "#home",
    data: {
        study: { // 学生活动
            title: "学生活动",
            link: {
                activity: "",
                wenhua: "",
                yanjius: "",
                benke: ""
            },
            img: {
                big: "dist/images/index/huodong.jpg",
                small: [
                    { src: "dist/images/index/wenhuaban.jpg" },
                    { src: "dist/images/index/yanjiusheng.jpg" },
                    { src: "dist/images/index/zhuanbenke.jpg" },
                ],
                class:"img-fluid float-left img-light",
            }
        },
        news: { // 新闻资讯
            head: {
                title: "新闻资讯",
                link: "?更多",
            },
            show: {
                title: "华南信息化教育研究院第四次工作会议召开",
                abstract: "延长校区的老师们、同学们：根据延长校区整体规划，延长校区一食堂、二食堂、三食堂、五食堂将于2017年12月23日（周六）进行拆 ",
                time: "18-01-01",
                link: "?敬请期待"
            },
            message: [
                {
                    text: "华南信息化教育研究院研究生陆续招生续招生续招生",
                    time: "18-05-04",
                    link: "index.html"
                },
                {
                    text: "华南信息化教育研究院研究生陆续招生",
                    time: "18-05-04",
                    link: "index.html"
                },
                {
                    text: "华南信息化教育研究院研究生陆续招生",
                    time: "18-05-04",
                    link: "index.html"
                },
                {
                    text: "华南信息化教育研究院研究生陆续招生",
                    time: "17-09-04",
                    link: "index.html"
                },
                {
                    text: "华南信息化教育研究院研究生陆续招生",
                    time: "17-09-04",
                    link: "index.html"
                },
            ]
        },
        trains: {// 教育培训
            head: {
                title: "教育培训",
                link: "?更多",
            },
            message: [ 
                {
                    text: "澳大利亚dasd卓越教师sdfsdfsd团队工作坊：Global Parasdastnershi- ps for Academic Te",
                    link: "index.html"
                },
                {
                    text: "社会认知与行为科学系列沙龙（34）：慢运动、审美 体验、幸福密码与 Parasdastnershi- ps for Academic Te",
                    link: "index.html"
                },
                {
                    text: "教学发展中心“午餐会”（总第108期）：当实验器 械遇到手机：实验教 Parasdastnershi- ps for Academic Te",
                    link: "index.html"
                },
                {
                    text: "上海交通大学科学史与科学文化研究院2017冬至会 议上海交通大学科学史与科学文化研究院2017冬至会 议,提倡冬至不宜吃狗肉，文明过节 Parasdastnershi- ps for Academic Te",
                    link: "index.html"
                },
            ]
        },
        inform: { // 通知公告
            head: {
                title: "通知公告",
                link: "?更多",
            },
            message: [ 
                {
                    num: "25",
                    time: "2018-03",
                    title: "深化部校共建新闻学院工作推进到一定的程度",
                    text: "深化步小远洪建安新闻仪式隆重举行了啊撒旦阿三的说法",
                    link: "?未知"
                },
                {
                    num: "22",
                    time: "2011-03",
                    title: "深化部校共建新闻学院工作推进到一定的程度",
                    text: "幸福密码与 Parasdastnershi- ps for Academic Te",
                    link: "?未知"
                },
                {
                    num: "99",
                    time: "2013-03",
                    title: "深化部校共建新闻学院工作推进到一定的程度",
                    text: "实验教 Parasdastnershi- ps for Academic Te",
                    link: "?未知"
                },
                {
                    num: "777",
                    time: "2011-03",
                    title: "深化部校共建新闻学院工作推进到一定的程度",
                    text: "史与科学文化研究院201肉，文明过节 Parasdastnershi- ps for Academic Te",
                    link: "?未知"
                },
            ]
        },
        intro: { // 学院概况
            head: {
                title: "学院概况",
                link: "?更多",
            },
            message: [ 
                {
                    text: "钱伟长学院本科生发表SCI一区一作学术论文",
                    link: "index.html"
                },
                {
                    text: "钱伟长学院本科生发表SCI一区一作学术论文 体验、幸福密码与 Parasdastnershi- ps for Academic Te",
                    link: "index.html"
                },
                {
                    text: "钱伟长学院本科生发表SCI一区一作学术论文 械遇到手机：实验教 Parasdastnershi- ps for Academic Te",
                    link: "index.html"
                },
                {
                    text: "大学科学史与科学文化研究院2017冬至会 议,提倡冬至不宜吃狗肉，文明过节 Parasdastnershi- ps for Academic Te",
                    link: "index.html"
                },
                {
                    text: "大学科学史与科学文化研究院2017冬至会 议,提倡冬至不宜吃狗肉，文明过节 Parasdastnershi- ps for Academic Te",
                    link: "index.html"
                },
                {
                    text: "大学科学史与科学文化研究院2017冬至会 议,提倡冬至不宜吃狗肉，文明过节 Parasdastnershi- ps for Academic Te",
                    link: "index.html"
                },
            ]
        },
    },
    methods: {
        showText: function (cont, num, num2) {

            // if (cont[0].time != undefined) {
            //     console.log("时间有");
            //     return;
            // }

            for (let i = 0; i < cont.length; i++) {
                let message = String(cont[i].text);
                if (message.length > num) {
                    let cutOut = message.slice(0, num);
                    cont[i].text = cutOut + "...";
                }
                let message1 = String(cont[i].title);
                if (message1.length > num2) {
                    let cutOut = message1.slice(0, num2);
                    cont[i].title = cutOut + "...";
                }
                // console.log(message1)
            }
        }
    }
})
home.showText(home.news.message, 16);
home.showText(home.trains.message, 40);
home.showText(home.inform.message, 15, 13);
home.showText(home.intro.message, 21);