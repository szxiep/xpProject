for(var i = 1900;i < 2019 ; i++)
{
    document.getElementById("year").innerHTML += '<option value="'+i+'">'+i+'年</option>';
}
for(var i = 1;i < 13 ; i++)
{

    if(i < 10){
        i = "0"+i;
    }
    document.getElementById("month").innerHTML += '<option value="'+i+'">'+i+'月</option>';
    
}
for(var i = 1;i < 31 ; i++)
{
     if(i < 10){
        i = "0"+i;
    }
    document.getElementById("day").innerHTML += '<option value="'+i+'">'+i+'</option>';
}
for(var i = 0;i < 24 ; i++)
{
     if(i < 10){
        i = "0"+i;
    }
    document.getElementById("time").innerHTML += '<option value="'+i+'">'+i+'时</option>';
}
for(var i = 0;i < 60 ; i++)
{
     if(i < 10){
        i = "0"+i;
    }
    document.getElementById("branch").innerHTML += '<option value="'+i+'">'+i+'分</option>';
}

$(document).ready(function() {
//  jQuery.jqtab = function(tabtit,tab_conbox,shijian) {
//    $(tab_conbox).find("ul").hide();
//    $(tabtit).find("li:first").addClass("curr").show(); 
//    $(tab_conbox).find("ul:first").show();
//  
//    $(tabtit).find("li").bind(shijian,function(){
//      $(this).addClass("curr").siblings("li").removeClass("curr"); 
//      var activeindex = $(tabtit).find("li").index(this);
//      $(tab_conbox).children().eq(activeindex).show().siblings().hide();
//      return false;
//    });
//  
//  };
//  $.jqtab("#tabs","#tab_conbox","click");
//
//  jQuery.jqtab2 = function(tabtit2,tab_conbox2,shijian2) {
//    $(tab_conbox2).find(".tabs-kk").hide();
//    $(tabtit2).find("li:first").addClass("curr").show(); 
//    $(tab_conbox2).find(".tabs-kk:first").show();
//  
//    $(tabtit2).find("li").bind(shijian2,function(){
//      $(this).addClass("curr").siblings("li").removeClass("curr"); 
//      var activeindex = $(tabtit2).find("li").index(this);
//      $(tab_conbox2).children().eq(activeindex).show().siblings().hide();
//      return false;
//    });
//  
//  };
//  $.jqtab2("#tabs2","#tab_conbox2","click");

    $("body").iealert();
       
    $("#tel").hover(function(){
        $("#tel-xl").show();
    },function(){
        $("#tel-xl").hide();
    });

    $(".nlzh a").click(function(){
    $(".zh-kk").show();
    }); 
    $(".qx-btn").click(function(){
    $(".zh-kk").hide();
    });

   //首先将#back-to-top隐藏
   $("#back-to-top").hide();
   //当滚动条的位置处于距顶部100像素以下时，跳转链接出现，否则消失
   $(function () {
       $(window).scroll(function () {
           if ($(window).scrollTop() > 100) {
               $("#back-to-top").fadeIn(1500);
           }
           else {
               $("#back-to-top").fadeOut(1000);
           }
       });
       //当点击跳转链接后，回到页面顶部位置
       $("#back-to-top").click(function () {
           $('body,html').animate({ scrollTop: 0 }, 1000);
           return false;
       });
   });
/*    $("#postBtn").click(submitCheSuan); */
});

var currYear = (new Date()).getFullYear();
    var opt={};
    opt.date = {
        preset : 'datetime',
        onSelect:function(valueText,inst){
          $('#tests').text(valueText);
          $('#solarDate').val(valueText);
      		//getgtime();
          if("23" == $('#tests').text().split(' ')[1].split(':')[0]) {
        	  $('#esss').show();
          } else {
        	  $('#esss').hide();
          }
          if(getXiaLingShi($('#tests').text())) {
             $('#xlsd').show();
          } else {
              $('#xlsd').hide();
          }
        },
        onBeforeShow: function (event, inst) {
        }
    };
    opt.datetime = {preset : 'datetime'};
    opt.default = {
        theme: 'android-holo light', //皮肤样式
        display: 'modal', //显示方式 
        mode: 'scroller', //日期选择模式
        dateFormat: 'yyyy-mm-dd',
        lang: 'zh',
        showNow: true,
        nowText: "今天",
        startYear: currYear - 117, //开始年份
        endYear: currYear + 20 //结束年份
    };
$("#tests").mobiscroll($.extend(opt['date'], opt['default']));

function TGDialogS(e){
            need("biz.dialog-min",function(Dialog){
                Dialog.show({
                    id:e,
                    bgcolor:'#000', //弹出“遮罩”的颜色，格式为"#FF6600"，可修改，默认为"#fff"
                    opacity:50 //弹出“遮罩”的透明度，格式为｛10-100｝，可选
                });
            });
        }
        function closeDialog(){
            need("biz.dialog-min",function(Dialog){
                Dialog.hide();
            });
        }


function getXiaLingShi(xinli) {
  var nianyueri = xinli.split(' ')[0];
  var nian = parseInt(nianyueri.split('-')[0]);
  var yueri = nianyueri.split('-')[1] + nianyueri.split('-')[2];
  yueri = parseInt(yueri.replace('-',''));
  if (nian>=1935&&nian<=1951){
    if(yueri>=0521&&yueri<=0930){
      return true;
    }
  }
  if (nian==1952){
    if(yueri>=0301&&yueri<=1031){
      return true;
    }
  }
  if (nian>=1953&&nian<=1954){
    if(yueri>=0401&&yueri<=1031){
      return true;
    }
  }
  if (nian>=1955&&nian<=1956){
    if(yueri>=0501&&yueri<=0930){
      return true;
    }
  }
  if (nian>=1957&&nian<=1959){
    if(yueri>=0401&&yueri<=0930){
      return true;
    }
  }
  if (nian>=1960&&nian<=1961){
    if(yueri>=0601&&yueri<=0930){
      return true;
    }
  }
  if (nian>=1974&&nian<=1975){
    if(yueri>=0401&&yueri<=1031){
      return true;
    }
  }
  if (nian==1979){
    if(yueri>=0701&&yueri<=0930){
      return true;
    }
  }
  if (nian==1986){
    if(yueri>=0413&&yueri<=0914){
      return true;
    }
  }
  if (nian==1987){
    if(yueri>=0412&&yueri<=0913){
      return true;
    }
  }
  if (nian==1988){
    if(yueri>=0410&&yueri<=0911){
      return true;
    }
  }
  if (nian==1989){
    if(yueri>=0416&&yueri<=0917){
      return true;
    }
  }
  if (nian==1990){
    if(yueri>=0415&&yueri<=0916){
      return true;
    }
  }
  if (nian==1991){
    if(yueri>=0414&&yueri<=0915){
      return true;
    }
  }
  return false;
}