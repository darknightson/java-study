<%--
author : 이경수
version : 2019-03-10
description : 음원사용통계/ 계약사별 - 리뉴얼
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/taglib.jsp" %>

<%@ include file="/WEB-INF/view/jsp/Common/include.jsp" %>
<html>
<head>
<title><fmt:message key="title.lh" /></title>
	<script src="/renew/js/datatables.min.js"></script>
    <script src="/renew/js/ui_custom_datatables.js"></script>
    <script src="/renew/js/full_numbers_no_ellipses.js"></script>
    <script src="/renew/js/gridPipeline.js"></script>
    <script src="/renew/js/jquery.datetimepicker.full.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.min.js"></script>
    
    <script src="<c:url value='/renew/js/common.document.js'/>"></script>
    <script src="<c:url value='/renew/js/common.modalbox.js'/>"></script>
    <script src="<c:url value='/renew/js/common.datatables.js'/>"></script>
    <script src="<c:url value='/renew/js/biz/calculatemgmt/fn.commons.js'/>"></script>
	<script src="/renew/js/gnb-backgroud.js"></script>
    <style>
        tr.selected td {
            background-color: #fdf5e6;
        }
    </style>
        
    <script>
        'use strict';
        $(document).ready(function () {
            var unfoldClass = 'group_flex_unfold';

            var $excelBtn = $('#excelBtn');
            var $downFold = $('.group_fold_down');
			console.log("#####################");
            console.log("####: " + $('#channelCode').val());

            if ( $('#channelCode').val() == '07') {
				$("select option[value*='album']").prop('disabled',true);
				$("select option[value*='music']").prop('disabled',true);
				$("select option[value*='artist']").prop('disabled',true);
				$("select option[value*='BP']").prop('disabled',true);
				$("select option[value*='service']").prop('disabled',true);
				$("select option[value*='day']").prop('disabled',true);
				$("#day_month").val("month");
				dojo.byId("searchKeyWord").disabled=true;
			}
            else {
				$("select option[value*='album']").prop('disabled',false);
				$("select option[value*='music']").prop('disabled',false);
				$("select option[value*='artist']").prop('disabled',false);
				$("select option[value*='BP']").prop('disabled',false);
				$("select option[value*='service']").prop('disabled',false);
				$("select option[value*='day']").prop('disabled',false);
				//$("#day_month").val("month");
				dojo.byId("searchKeyWord").disabled=false;
			}

            $('#goCondDetail').on('click', function () {
                $('.group_flex_fold').toggleClass(unfoldClass);
            });

            $('input[name="searchDown"]').on('click', function () {
                if ($('#searchDown')[0].checked) {
                    $excelBtn.show();
                    $downFold.addClass(unfoldClass);
                } else {
                    $excelBtn.hide();
                    $downFold.removeClass(unfoldClass);
                }
            });
            
            
			$('input[type=text][name=startCalDate]').on('click', function() {
				var dayMonth = $("#day_month option:selected").val();
                $(this).datetimepicker({
                    format       : 'YYYY-MM-DD',
                    formatDate   : 'YYYY-MM-DD',
                    step         : 30,
                    timepicker   : false,
                    scrollInput  : false,
                    onSelectDate:function(val, $button){
						var cDate = val;
						if(dayMonth == "day") {
							cDate = fn_calFormatter(val, 'YYYY-MM-DD');
						} else if(dayMonth == "month"){
							cDate = fn_calFormatter(new Date(val.getFullYear(),val.getMonth(),"01"), 'YYYY-MM-DD');
						}
                        $('input[type=text][name=startCalDate]').val(cDate);
                    }
                });
            });
			
			$('input[type=text][name=endCalDate]').on('click', function() {
				var dayMonth = $("#day_month option:selected").val();
                $(this).datetimepicker({
                    format       : 'YYYY-MM-DD',
                    formatDate   : 'YYYY-MM-DD',
                    step         : 30,
                    timepicker   : false,
                    scrollInput  : false,
                    onSelectDate:function(val, $button){
						var cDate = val;
						if(dayMonth == "day") {
							cDate = fn_calFormatter(val, 'YYYY-MM-DD');
						} else if(dayMonth == "month"){
							cDate = fn_calFormatter(new Date(val.getFullYear(),val.getMonth()+1,"0"), 'YYYY-MM-DD');
						}
                        $('input[type=text][name=endCalDate]').val(cDate);
                    }
                });
            });
			
			
			$('#day_month').on('change', function () {
               var dayMonth = $("#day_month option:selected").val();
			   var startDate = $('input[type=text][name=startCalDate]').val()
			   var endDate = $('input[type=text][name=endCalDate]').val()
			   if(startDate != "" && endDate!= "") {
				   var startDateFromat = new Date(startDate);
				   var endDateFromat = new Date(endDate);
					if(dayMonth == "month"){
						startDate = fn_calFormatter(new Date(startDateFromat.getFullYear(),startDateFromat.getMonth(),"01"), 'YYYY-MM-DD');
						endDate = fn_calFormatter(new Date(endDateFromat.getFullYear(),endDateFromat.getMonth()+1,"0"), 'YYYY-MM-DD');
				    } else{
						startDate = fn_calFormatter(startDate, 'YYYY-MM-DD');
						endDate = fn_calFormatter(endDate, 'YYYY-MM-DD');
					}
				  $('input[type=text][name=startCalDate]').val(startDate);
				  $('input[type=text][name=endCalDate]').val(endDate);
			   }
            });
			
			
			var fn_calFormatter = function(cdate, cformat) {
                var fdate = moment(cdate).format(cformat);
				return fdate;
            };
			
            var fnCreateCalendar  = fnMLB.commons.component.timepicker.create;
            var fnInit_Calendar = function() {
				var today = new Date();
				var dayMonth = $("#day_month option:selected").val();
				var formatter = "YYYY-MM-DD";

                fnCreateCalendar('input[type=text][name=startCalDate]', "YYYY-MM-DD", true);
                fnCreateCalendar('input[type=text][name=endCalDate]', "YYYY-MM-DD", true);
                $('input[type=text][name=startCalDate], input[type=text][name=endCalDate]').bind('change_servie_date', function () {
                    console.log('trigger for calendar value change event');
                });
				
				var sdate = "${page.startCalStrDate}";
				var edate = "${page.endCalDateStr}";
				
				if(sdate == "" && edate == ""){
					$('input[type=text][name=startCalDate]').val(fn_calFormatter(new Date(today.getFullYear(),today.getMonth(),"01"), "YYYY-MM-DD"));
					$('input[type=text][name=endCalDate]').val(fn_calFormatter(today, "YYYY-MM-DD"));
				} else {
					if(dayMonth == "month"){
						sdate = new Date(fn_calFormatter(sdate+"01", "YYYY-MM-DD"));
						sdate = fn_calFormatter(sdate, 'YYYY-MM-DD');
						edate = new Date(fn_calFormatter(edate+"01", "YYYY-MM-DD"));
						edate = fn_calFormatter(new Date(edate.getFullYear(),edate.getMonth()+1,"0"), 'YYYY-MM-DD');
						$('input[type=text][name=startCalDate]').val(fn_calFormatter(sdate, "YYYY-MM-DD"));
						$('input[type=text][name=endCalDate]').val(fn_calFormatter(edate, "YYYY-MM-DD"));	
					} else {
						$('input[type=text][name=startCalDate]').val(fn_calFormatter(sdate, "YYYY-MM-DD"));
						$('input[type=text][name=endCalDate]').val(fn_calFormatter(edate, "YYYY-MM-DD"));
					}
				}
			};
            fnInit_Calendar();
        });
    </script>
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/ri/dojo-release-1.3.1/dijit/themes/nihilo/nihilo.css" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ri/css/mlb2_lh.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ri/css/menu_lh.css"> --%>

<!-- load the dojo toolkit base -->
<script type="text/javascript" src="${pageContext.request.contextPath}/ri/js/dojo-config.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ri/dojo-release-1.3.1/dojo/dojo.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ri/js/common.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ri/js/common_n_mlb.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ri/js/mlb2DojoWait.js" ></script>

<!-- KONAN : 자동완성 스크립트 선언부  -->
<!-- script type="text/javascript" src="${pageContext.request.contextPath}/konan/js/akc4.js"></script-->
<!-- KONAN : 자동완성 스크립트 선언부 ) -->
<script type="text/javascript">
<!--
	var loadImageUrl = "<c:url value='/images/loading.gif'/>";

	dojo.require("dijit.form.DateTextBox");
	dojo.require("dijit.form.Form");
	dojo.require("dijit.Tooltip");
	dojo.require("dojo.parser");
	var searchCount = 0; //검색중 count

	// 검색 시 데이터 값 체크
	function searchValidation(){

		var start = dojo.byId('startCalDate').value;
		var end = dojo.byId('endCalDate').value;
		var checkDate = '';

		var startDate = new Date(start.substring(0,4), start.substring(5,7), start.substring(8,11));
		var endDate = new Date(end.substring(0,4), end.substring(5,7), end.substring(8,11));

		if(dojo.byId('day_month').value == 'day'){
			startDate.setMonth(startDate.getMonth()+2);

			if(startDate < endDate ){
				alert("가능 검색 기간은 2개월 입니다.");
				dojo.byId('endCalDate').focus();
				return false;
			}

		}else if(dojo.byId('day_month').value == 'month'){
			startDate.setMonth(startDate.getMonth()+24);

			if(startDate < endDate){
				alert("가능 검색 기간은 24개월 입니다.");
				dojo.byId('endCalDate').focus();
				return false;
			}
		}

		if(dojo.byId('startCalDate').value == ""){
			alert("<fmt:message key="error.not-specified"/>"); //필수 입력해야 합니다.
			dojo.byId('startCalDate').focus();
			return false;
		}
		if(dojo.byId('endCalDate').value == ""){
			alert("<fmt:message key="error.not-specified"/>"); //필수 입력해야 합니다.
			dojo.byId('endCalDate').focus();
			return false;
		}

	    if(dojo.byId('startCalDate').value > dojo.byId('endCalDate').value && dojo.byId('endCalDate').value != ""){
			alert("<fmt:message key="soundmgmt.newreg.dateCheck"/>"); //검색 조건의 시작일이 종료일 보다 큽니다!
			return false;
		}

		if(dojo.byId('searchCondDetail').value == "all" && dojo.byId('searchKeyWord').value != ""){
			alert("검색하고자 하는 이름이나 코드를 선택하세요.");
			dojo.byId('searchCondDetail').focus();
			return false;
		}

		if(dojo.byId("downCode").value == "all"){
			alert("검색하고자 하는 권리사를 선택하세요.");
			dojo.byId("downCode").focus();
			return false;
		}

		return true;
	}

	function makeAfterDate(startDate){

		var checkDate = '';

		if(String(startDate.getMonth()+1).length==1){
			if(String(startDate.getDate()).length==1){
				checkDate = String(startDate.getFullYear()) + '.0' + String(startDate.getMonth()+1) + '.0' + String(startDate.getDate());
			}else{
				checkDate = String(startDate.getFullYear()) + '.0' + String(startDate.getMonth()+1) + '.' + String(startDate.getDate());
			}
		}else{
			if(String(startDate.getDate()).length==1){
				checkDate = String(startDate.getFullYear()) + '.' + String(startDate.getMonth()+1) + '.0' + String(startDate.getDate());
			}else{
				checkDate = String(startDate.getFullYear()) + '.' + String(startDate.getMonth()+1) + '.' + String(startDate.getDate());
			}
		}
		return checkDate;
	}

	function goSearch() {

		var searchForm = dojo.byId("searchForm");
		var downCode = dojo.byId("downCode").value;

		if(searchValidation()){
			dojo.byId('level').value = "admin"; //level이 'admin'이면, 해당 메인 리스트 조회, 아니면 상세리스트조회
		    searchForm.pageNo.value = "1";
		    searchForm.pageSize.value = "50";
		    dojo.byId("downCodeDe").value = downCode;
		 	searchForm.submit();
		 	displayWait();
		}
	}

	function handleSubmit(event) {
		dojo.stopEvent(event);
		goSearch();
	}

	//화면 로드시, 채널코드,관점별 검색값을 기억한다.
	function loadFunc(searchCond,searchCondDetail){

	    selectKind(searchCond,searchCondDetail); //관점선택

	   <c:if test="${empty page.channelOnOff}">
			getChannelList("on", true); // 기본 채널 ON
		</c:if>
		<c:if test="${not empty page.channelOnOff}">
			getChannelList("${page.channelOnOff}", true);
		</c:if>

		//getServiceCodeList();
	    //setTimeout(setServiceCodeDisabled,1000);
	    if (searchCond == "") {
	   		setUpBySearchCondAll();
	    }
	}

	function setServiceCodeDisabled(){
	    if(document.searchForm.serviceCode!=undefined){
	        document.searchForm.serviceCode.disabled = true;
	    }
	}

	//국가별 채널 리스트 조회
    function getChannelList(channelOnOff, fromLoad){
    	var channel = "${page.channelCode}"; //채널 선택 후 검색조건인 채널이 남아있기 위해 필요함
        var xhrArgs = {
        			  url: "<c:url value='/Common/searchChannelByOnOff.do?channelOnOff='/>" + channelOnOff+ "&channel=" + channel,
		          handleAs: "text",
		          load: function(data){
		          	  var channelbyNationDiv = dojo.byId("channelbyNation");
		        	  	channelbyNationDiv.innerHTML = data;
		        	  if (!fromLoad) {
	            	 selectKind(dojo.byId("searchCond").value,dojo.byId("searchCondDetail").value);
		        	  }
		          },
		          error: function(error){
		        	  alert(error);
		          }
		      }
		var deferred = dojo.xhrGet(xhrArgs);

    }

	//관점별 해당 관련항목을 보여주는  페이지로 이동
	function getEmptyPage(){
		//alert('getEmptyPage() - ' + dojo.byId("searchCondAll").options[dojo.byId("searchCondAll").selectedIndex].value);
		
     
		
		var xhrArgs = {
		          url: "${pageContext.request.contextPath}/LH/musicstat2/usage/usageEmptyPage.do",
		          handleAs: "text",
		          form: "searchForm",
		          load: function(data){
		        	  var usageListDiv = dojo.byId("usageListDiv");
		        	  usageListDiv.innerHTML = data;
		        	  downloadViewFunc();
		          },
		          error: function(error){
		        	  alert(error);
		          }
		      }
		var deferred = dojo.xhrPost(xhrArgs);
	}

	function setUpBySearchCondAll(value) {
		//document.searchForm.searchCond.disabled = true;
		//document.searchForm.searchCondDetail.disabled = true;
		//document.searchForm.searchKeyWord.value = "";
		//document.searchForm.searchKeyWord.disabled = true;
		document.searchForm.serviceType.disabled = true;  //서비스>그룹/상세 비활성화

		// searchCond
		var temp = dojo.query("#searchCond option");
		var ok = false;
		dojo.forEach(temp,function(i){
			if(i.value == "all")
				ok = true ;
			} );

		if(! ok) {
			var element = dojo.doc.createElement("option" );
			element.value = "all" ;
			element.innerHTML = "전체";
			element.selected = "true";
			dojo.byId("searchCond" ).appendChild(element,0);
			dojo.place(element, dojo.byId("searchCond" ), "first" );
		}
		dojo.byId("searchCond").selectedIndex = 0;
	//	document.searchForm.searchCond.options[0] = new Option("전체","all");
	//	document.searchForm.searchCond.options[0].selected = true;

		// searchCondDetail
		var newElem;
	    var where = (navigator.appName == "Microsoft Internet Explorer") ? -1 : null;
	    var condDetail = document.searchForm.elements["searchCondDetail"];
	    while (condDetail.options.length) {
	    	condDetail.remove(0);
	    }
	    newElem = document.createElement("option");
	    newElem.text = "전체";
	    newElem.value = "all";
	    condDetail.add(newElem, where);

		// add by dark 2022.07.14
		if ( value == '07') {
			$("select option[value*='album']").prop('disabled',true);
			$("select option[value*='music']").prop('disabled',true);
			$("select option[value*='artist']").prop('disabled',true);
			$("select option[value*='BP']").prop('disabled',true);
			$("select option[value*='service']").prop('disabled',true);
			$("select option[value*='day']").prop('disabled',true);
			$("#day_month").val("month");
			dojo.byId("searchKeyWord").disabled=true;
		}
		else {
			$("select option[value*='album']").prop('disabled',false);
			$("select option[value*='music']").prop('disabled',false);
			$("select option[value*='artist']").prop('disabled',false);
			$("select option[value*='BP']").prop('disabled',false);
			$("select option[value*='service']").prop('disabled',false);
			$("select option[value*='day']").prop('disabled',false);
			dojo.byId("searchKeyWord").disabled=false;
		}
		// end
	}

	function setUpBySearchCondNotAll() {
		document.searchForm.searchCond.disabled = false;
		document.searchForm.searchCondDetail.disabled = false;
		document.searchForm.searchKeyWord.disabled = false;

		var channelCode = document.searchForm.elements["channelCode"];
		var cond= document.searchForm.elements["searchCond"];
		// add by dark 2022.07.14
		$("select option[value*='album']").prop('disabled',false);
		$("select option[value*='music']").prop('disabled',false);
		$("select option[value*='artist']").prop('disabled',false);
		$("select option[value*='BP']").prop('disabled',false);
		$("select option[value*='service']").prop('disabled',false);
		$("select option[value*='day']").prop('disabled',false);
		dojo.byId("searchKeyWord").disabled=false;
		// end
	    if( cond[0].value == "all")
	    	cond.remove(0);
	    var index = -1;
		dojo.forEach(cond,function(el,i){
			if( el.selected == true ){
			  index = i ;

			}
		});
		if(index == 0)
			selectKind('album', '1');

	//	document.searchForm.searchCond.options[0] = new Option("음반별","album");
	//	document.searchForm.searchCond.options[0].selected = true;

//		dojo.byId("searchCond").options[5] = new Option("곡_BP별","BM");
//		if(value == '01' || value == '02') {
//			dojo.byId("searchCond").options[5] = null;
//		}
 		//dojo.style("btn_exdn","display","inline");
 		}

	//채널별  해당서비스조회
 	// add by dark value parameter 추가 2022.07.14
	function getChannelServices(value) {
		//전체인 경우는 관점별, 관점상세별, 검색어  비활성화

		if(value == ''||value == 'all' || value == '07'){
			setUpBySearchCondAll(value);
			document.searchForm.searchKeyWord.value = "";
	 	}else{
	 		setUpBySearchCondNotAll();
	 	}
	}

	//서비스 상세 selelctbox 리스트 조회
	function getServiceCodeList(){
	    var xhrArgs = {
		          url: "${pageContext.request.contextPath}/LH/musicstat2/usage/serviceGroupList.do",
		          handleAs: "text",
		          form: "searchForm",
		          load: function(data){
		        	  var serviceDiv = dojo.byId("serviceDiv");
		        	  serviceDiv.innerHTML = data;
		          },
		          error: function(error){
		        	  alert(error);
		          }
		      }
		var deferred = dojo.xhrPost(xhrArgs);
	}

	//검색조건별 해당 select 리스트
	var regiondb = new Object()
	regiondb["album"] = [{value:"1", text:"음반명"},
	                     {value:"2", text:"음반코드"}];
	regiondb["music"] = [{value:"1", text:"곡명"},
		                 {value:"2", text:"곡코드"}];
	regiondb["artist"] = [{value:"1", text:"아티스트명"},
		                  {value:"2", text:"아티스트코드"}];
	regiondb["BP"] = [{value:"1", text:"BP명"},
	                  {value:"2", text:"BP코드"}];

	//관점별  : 계약사별,기획사별,음반별,곡별,서비스별 등 선택시
	function selectKind(chooser,detail) {
	    //chooser : 계약사 등 선택한 값
	    //detail  : 계약사명,계약사코드 등 선택한 값
	    var channelCode = dojo.byId("channelCode").value;
	    if(detail=="" ){
	    	 downloadViewFunc();
	   	    getEmptyPage();
	   		dojo.byId("level").value = "admin";
	   		//document.searchForm.searchKeyWord.value = "";
	    }

		var newElem;
	    var where = (navigator.appName == "Microsoft Internet Explorer") ? -1 : null;
	    var condDetail = document.searchForm.elements["searchCondDetail"];
	    while (condDetail.options.length) {
	    	condDetail.remove(0);
	    }

	    if(chooser == ""||chooser == "all"||chooser == "MusicBP"||chooser == "service") {
		    newElem = document.createElement("option");
		    newElem.text = "전체";
		    newElem.value = "all";
		    condDetail.add(newElem, where);
	    }

	    if(chooser == ""||chooser == "all"){
	    	document.searchForm.searchKeyWord.value = "";
	    	document.searchForm.searchKeyWord.disabled = true; //검색어 비활성화
	    	document.searchForm.serviceType.disabled = true;
	    	dojo.style("serviceDiv","display","none");
	   	    dojo.style("serviceDiv2","display","inline");
	   	    <c:if test="${empty page.startCalDate}">
	   	 		setUpBySearchCondNotAll();
	   	    </c:if>
	   	 	<c:if test="${not empty page.startCalDate}">
	   	 		setUpBySearchCondAll();
	   	    </c:if>
	    	//document.getElementById('serviceCode').disabled = true;
	    }else if(chooser=="service"){
	    	document.searchForm.searchKeyWord.value = "";
	    	document.searchForm.searchKeyWord.disabled = true;
	   	    document.searchForm.serviceType.disabled = false; //서비스>그룹/상세 활성화
	   	    dojo.style("serviceDiv","display","inline");
	   	 	dojo.style("serviceDiv2","display","none");
	   	    getServiceCodeList(); //서비스 리스트 조회
	    }else{
		    if (chooser == "MusicBP") {
		    	document.searchForm.searchCondDetail.disabled = true;
				//document.searchForm.searchKeyWord.value = "";
				document.searchForm.searchKeyWord.disabled = true;
		    } else {
		    	document.searchForm.searchCondDetail.disabled = false;
				//document.searchForm.searchKeyWord.value = "";
				document.searchForm.searchKeyWord.disabled = false;

			    var db = regiondb[chooser];
			    for (var i = 0; i < db.length; i++) {
		            newElem = document.createElement("option");
		            newElem.text = db[i].text;
		            newElem.value = db[i].value;
		            condDetail.add(newElem, where);
					// 선택한 명(1)과 코드(2)의 재설정
		            if((i+1)==detail){
		                newElem.selected = true;
		            }
		        }
		    }

	        document.searchForm.serviceType.disabled = true;  //서비스>그룹/상세 비활성화
	        dojo.style("serviceDiv","display","none");
	   	    dojo.style("serviceDiv2","display","inline");
	  	 	//document.getElementById('serviceCode').disabled = true;
	    }
	    downloadViewFunc();
	}

	//상세명,상세코드 선택 이벤트
	function selectKindDetail(value){
		//document.searchForm.searchKeyWord.value = "";
		if(value == 'all'){
			document.searchForm.searchKeyWord.disabled = true;
		}else{
			document.searchForm.searchKeyWord.disabled = false;
			document.searchForm.searchKeyWord.focus();
		}
	}

function showDateSelectBox(dateId) {
//	dijit.byId(dateId).toggleDropDown();
	dojo.byId(dateId).focus();
}
	
	function gotoPage(pageNo) {

		var searchForm = dojo.byId("searchForm");
		searchForm.pageNo.value = pageNo;
		searchForm.pageSize.value = "50";
		searchForm.submit();
		displayWait();
	}

	//상세검색 버튼 선택시, 하단상세검색영역 view 처리
	function goCondDetail(){
		var detailCond = dojo.query("#detailCond")
		var currentDisplay = detailCond.style("display");

		if(currentDisplay == "block"){  // 이미 보일때
			detailCond.style("display","none");
		    document.searchForm.detailCheck.value = "";
		}else{
			detailCond.style("display","block");
			document.searchForm.detailCheck.value = "view";
		}


	}

	//계약사별-음반별 호출   usageContractList.jsp
	function goContractAlbumList(pcCode){
		dojo.byId("pcCode").value = pcCode;
		dojo.byId("level").value = "contractAlbum";
		searchForm.pageNo.value = "1";
	    searchForm.submit();
	    displayWait();
	}

	//계약사별-음반별-곡별  호출  usageMusicList.jsp
	function goContractAlbumMusicList(albumCode){
	    dojo.byId("albumCode").value = albumCode;
		dojo.byId("level").value = "contractAlbumMusic";
		searchForm.pageNo.value = "1";
	    searchForm.submit();
	    displayWait();
	}

	//음반별-곡별 호출  usageMusicList.jsp
	function goAlbumMusicList(albumCode, albumName, downCode){
		dojo.byId("level").value = "albumMusic";
	    dojo.byId("albumCode").value = albumCode;
	    dojo.byId("albumName").value = albumName;
	    dojo.byId("downCodeDe").value = downCode;
		searchForm.pageNo.value = "1";
	    searchForm.submit();
	    displayWait();
	}


	//곡별-곡별_BP 서비스 호출  usageMusicList.jsp
	function goMusicBpList(musicCode, musicName, downCode){
		dojo.byId("level").value = "musicBpService";
	    dojo.byId("musicCode").value = musicCode;
	    dojo.byId("musicName").value = musicName;
	    dojo.byId("downCodeDe").value = downCode;
		searchForm.pageNo.value = "1";
	    searchForm.submit();
	    displayWait();
	}

	//가수별-음반별 호출  usageAlbumList.jsp
	function goArtistAlbumList(musicSingerCode, musicSingerName){
		dojo.byId("level").value = "artistAlbum";
	    dojo.byId("musicSingerCode").value = musicSingerCode;
	    dojo.byId("musicSingerName").value = musicSingerName;
		searchForm.pageNo.value = "1";
	    searchForm.submit();
	    displayWait();
	}

	//가수별-음반별-곡별 호출  usageMusicList.jsp
	function goArtistAlbumMusicList(albumCode){
		dojo.byId("level").value = "artistAlbumMusic";
	    dojo.byId("albumCode").value = albumCode;
		searchForm.pageNo.value = "1";
	    searchForm.submit();
	    displayWait();
	}

	//서비스별-음반 곡별 호출  usageMusicList.jsp
	function goServiceAlbumList(serviceCode, serviceName, downCode){
		dojo.byId("level").value = "serviceAlbum";
	    dojo.byId("serviceCodeVal").value = serviceCode;
	    dojo.byId("serviceName").value = serviceName;
	    dojo.byId("downCodeDe").value = downCode;
		searchForm.pageNo.value = "1";
	    searchForm.submit();
	    displayWait();
	}

	//BP별-음반별 호출  usageAlbumList.jsp
	function goBpAlbumList(bpCode){
		dojo.byId("level").value = "bpAlbum";
	    dojo.byId("bpCode").value = bpCode;
		searchForm.pageNo.value = "1";
	    searchForm.submit();
	    displayWait();
	}

	//BP별-음반별-곡별 호출  usageMusicList.jsp
	function goBpAlbumMusicList(albumCode){
		dojo.byId("level").value = "bpAlbumMusic";
	    dojo.byId("albumCode").value = albumCode;
		searchForm.pageNo.value = "1";
	    searchForm.submit();
	    displayWait();
	}

	  //엑셀다운로드
	function goExcel(){
		dojo.byId("excelDownType").value = "ex";
		var searchForm = dojo.byId("searchForm");
		var orgAction = searchForm.action;
		searchForm.top.value = top; //top 5~10
		<c:if test="${not empty excelServerUrl}">
		searchForm.action = "${excelServerUrl}/LH/musicstat2/usage/usageListExcel2.do",
		</c:if>
		<c:if test="${empty excelServerUrl}">
		searchForm.action = "<c:url value='/LH/musicstat2/usage/usageListExcel2.do'/>",
		</c:if>
		searchForm.submit();
		searchForm.action = orgAction;
		dojo.style("btn_exdn","display","none");
		
	}
	//엑셀 예약다운로드
	function goExcelRes(){
		dojo.byId("excelDownType").value = "rx";
	    var xhrArgs = {
	                <c:if test="${not empty excelServerUrl}">
					url: "${excelServerUrl}/LH/musicstat2/usage/usageListExcel.do",
					</c:if>
					<c:if test="${empty excelServerUrl}">
	                url: "<c:url value='/LH/musicstat2/usage/usageListExcel.do'/>",
					</c:if>
	                handleAs: "text",
	                form: "searchForm",
	                load: function(data){
	                      alert(data);
	                },
	               error: function(error){
	                     alert(error);
	                }
	    }
		var deferred = dojo.xhrPost(xhrArgs);
	}

	//서비스별 엑셀 예약다운로드
	function goServiceExcelRes(){
		dojo.byId("excelDownType").value = "rx";
		if(dojo.byId("level").value == 'artistAlbum'){
			dojo.byId("level").value = "artisetServiceExcelDn";
		}else{
			dojo.byId("level").value = "serviceExcelDn";
		}
		<c:if test="${not empty usagelist}">
	    var xhrArgs = {
	                <c:if test="${not empty excelServerUrl}">
					url: "${excelServerUrl}/LH/musicstat2/usage/usageListExcel.do",
					</c:if>
					<c:if test="${empty excelServerUrl}">
	                url: "<c:url value='/LH/musicstat2/usage/usageListExcel.do'/>",
					</c:if>
	                handleAs: "text",
	                form: "searchForm",
	                load: function(data){
	                      alert(data);
	                },
	               error: function(error){
	                     alert(error);
	                }
	    }
		var deferred = dojo.xhrPost(xhrArgs);
		</c:if>
		<c:if test="${empty usagelist}">
		alert("엑셀예약다운로드할 데이터가 없습니다.");
		</c:if>
	}

	function constrainDateBox(dayGubun) {
		var today = new Date();
		var date1 = today;
		if (dayGubun == "day") {
			dijit.byId("startCalDate").constraints.datePattern = "yyyy.MM.dd";
			dijit.byId("endCalDate").constraints.datePattern = "yyyy.MM.dd";

			dijit.byId("startCalDate").attr("value", new Date(today.getFullYear(),today.getMonth(),"01"));
			dijit.byId("endCalDate").attr("value", today);
/*			
			dijit.byId("endCalDate").attr("value", today);
			today.setDate("01")
			dijit.byId("startCalDate").attr("value",today );
*/
			//alert(dijit.byId("endCalDate").attr("value"));
		} else if (dayGubun == "month") {
			dijit.byId("startCalDate").constraints.datePattern = "yyyy.MM";
			dijit.byId("endCalDate").constraints.datePattern = "yyyy.MM";
			
			dijit.byId("startCalDate").attr("value", new Date(today.getFullYear(),today.getMonth()-1,"01"));
			dijit.byId("endCalDate").attr("value", new Date(today.getFullYear(),today.getMonth(),"01"));
/*			
			today.setDate("01");
			dijit.byId("endCalDate").attr("value",today);
			today.setMonth(today.getMonth()-1);
			dijit.byId("startCalDate").attr("value", today);
*/			
		}
	}

	dojo.addOnLoad(function(){
		loadFunc('${page.searchCond}','${page.searchCondDetail}');
	
		downloadViewFunc();

	});
	function downloadViewFunc(){
		var resultCount = 0 ;
		dojo.query("table.tbl_comm tr" ).forEach(function(node, i){
			resultCount += 1;
			 });

		 if(resultCount > 2){  //검색후
			/* if(dojo.byId("searchCond").value == "MusicBP" ){
				dojo.style("btn_exdnbm","display","inline");
				dojo.style("btn_exdn","display","none");
				dojo.style("btn_exdnsvc","display","none");
			}else */ if(dojo.byId("searchCond").value == "service" || dojo.byId("searchCond").value == "BP"){
				dojo.style("btn_exdnbm","display","none");
				dojo.style("btn_exdn","display","inline");
				dojo.style("btn_exdnsvc","display","none");

			}else {
				dojo.style("btn_exdnbm","display","none");
				dojo.style("btn_exdn","display","inline");
				dojo.style("btn_exdnsvc","display","inline");
			}
		 } else {//검색이 아닐때
/* 			 if(dojo.byId("searchCond").value == "MusicBP" ){
				 dojo.style("btn_exdnbm","display","inline");
			 }else {
				dojo.style("btn_exdnbm","display","none");
			 } */
			 	dojo.style("btn_exdnbm","display","none");
				dojo.style("btn_exdn","display","none");
				dojo.style("btn_exdnsvc","display","none");

		}
	}
--></script>
</head>

<!-- body table -->
<body>

<%-- <table width="1010" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="30" height="85" rowspan="3"><img alt="" src="/image/ml_bg_3.gif" width="30" height="85"></td>
    <td height="85" rowspan="3"><img alt="" src="/image/mlt_3a1.gif"></td>
	<td width="400" height="50"></td>
    <td width="15" height="85" rowspan="3"></td>
  </tr>
  <tr>
    <td width="400" height="15" class="Ahome">
	    <span class="Ahome">HOME&nbsp;&gt;&nbsp;음원사용통계&nbsp;&gt;&nbsp;</span>
	    <span class="Ahome1">당월통계/정산&nbsp;&gt;&nbsp;</span>
	    <span class="Ahome1">
	    	<c:if test="${page.searchCond == 'all'}">채널별&nbsp;&gt;&nbsp;</c:if>
			<c:if test="${page.searchCond == 'album'}">음반별&nbsp;&gt;&nbsp;
				<c:if test="${page.level == 'albumMusic'}">곡별&nbsp;&gt;&nbsp;</c:if>
			</c:if>
			<c:if test="${page.searchCond == 'music'}">곡별&nbsp;&gt;&nbsp;
				<c:if test="${page.level == 'musicBpService'}">BP별&nbsp;&gt;&nbsp;</c:if>
			</c:if>
			<c:if test="${page.searchCond == 'artist'}">아티스트별&nbsp;&gt;&nbsp;
				<c:if test="${page.level == 'artistAlbum'}">음반별&nbsp;&gt;&nbsp;</c:if>
			</c:if>
			<c:if test="${page.searchCond == 'service'}">서비스별&nbsp;&gt;&nbsp;
				<c:if test="${page.level == 'serviceAlbum'}">음반별&nbsp;&gt;&nbsp;</c:if>
			</c:if>
			<c:if test="${page.searchCond == 'BP'}">BP별&nbsp;&gt;&nbsp;
				<c:if test="${page.level == 'bpAlbum'}">음반별&nbsp;&gt;&nbsp;</c:if>
				<c:if test="${page.level == 'bpAlbumMusic'}">음반별&nbsp;&gt;&nbsp;곡별&nbsp;&gt;&nbsp;</c:if>
			</c:if>
			<c:if test="${page.searchCond == 'MusicBP'}">곡_BP별&nbsp;&gt;&nbsp;</c:if>
		</span>
	    <span class="Ahome">&nbsp;&nbsp;</span>
    </td>
  </tr>
  <tr>
    <td width="400" height="20"></td>
  </tr>
</table> --%>
<h2 id="kakaoBody" class="screen_out">당월통계&#47;정산</h2>
<form id="searchForm" name="searchForm" action="${pageContext.request.contextPath}/renewal/musicstat2/month.do"  method="POST" onsubmit="return false;"  >
<fieldset class="fld_filter_flex">	
	<legend class="screen_out">음원 사용 통계 필터</legend>
	<input type="hidden" id="pageNo" name="pageNo" value="${page.pageNo}">
	<input type="hidden" id="pageSize" name="pageSize" value="${page.pageSize}">
	<input type="hidden" id="rowCount" name="rowCount" value="${page.rowCount}">
	<input type="hidden" id="detailCheck" name="detailCheck" value="${page.detailCheck}">
	<input type="hidden" id="gubun" name="gubun" value="summary">
	<input type="hidden" id="level" name="level" value="${page.level}">
	<input type="hidden" id="currentLevel" name="currentLevel" value="${page.level}">
	<input type="hidden" id="tableWidth" name="tableWidth" value="${page.tableWidth}">
	<input type="hidden" id="pcCode" name="pcCode" value="${page.pcCode}">
	<input type="hidden" id="albumCode" name="albumCode" value="${page.albumCode}">
	<input type="hidden" id="albumName" name="albumName" value="<c:out value='${page.albumName}'/>">
	<input type="hidden" id="bpCode" name="bpCode" value="${page.bpCode}">
	<input type="hidden" id="downCodeDe" name="downCodeDe" value="${page.downCodeDe}">
	<input type="hidden" id="musicCode" name="musicCode" value="${page.musicCode}">
	
	<!-- <input type="hidden" name="startDate" id="startDate" >
	<input type="hidden" name="endDate" id="endDate" > -->
	
	<input type="hidden" id="musicName" name="musicName" value="<c:out value='${page.musicName}'/>">
	<input type="hidden" id="serviceCodeVal" name="serviceCodeVal" value="${page.serviceCodeVal}">
	<input type="hidden" id="serviceName" name="serviceName" value="<c:out value='${page.serviceName}'/>">
	<input type="hidden" id="excelDownType" name="excelDownType" value="">
	<input type="hidden" id="musicSingerCode" name="musicSingerCode" value="${page.musicSingerCode}">
	<input type="hidden" id="musicSingerName" name="musicSingerName" value="<c:out value='${page.musicSingerName}'/>">
	<input type="hidden" id="searchType" name="searchType" value="JS">
	<input type="hidden" id="userId" name="userId" value="${page.userId}">
	<input type="hidden" id="upPcCode" name="upPcCode" value="${page.upPcCode}">

	<!-- oz chart용 -->
	<input type="hidden" id="seq" name="seq" value="${page.seq}">
	<input type="hidden" id="top" name="top" value="">

	
	<div class="container">
		<div class="radio_comm">
			<input type="radio" id="searchRefer" name="searchDown" checked>
			<label for="searchRefer">조회</label>
		</div>
	</div>      
	<div class="container">
		<div class="group_fold">
			<div class="group_flex">
				<strong class="tit_filter">조건</strong>
				<%-- <div class="opt_comm" style="width:60px">
					<select class="select1" style="width:50px" name="searchType" id="searchType">
						<option value="JS" <c:if test="${page.searchType == 'JS' || page.searchType == null}">selected</c:if> >정산</option>
						<option value="TG" <c:if test="${page.searchType == 'TG'  }">selected</c:if>>통계</option>
      				</select>
				</div> --%>
				<div class="opt_comm opt_md">
			      	<div id="channelbyNation">
			      		<input type="hidden" name="channelCode" id="channelCode" value="${page.channelCode}">
			      	</div>
				</div>
				<div class="opt_comm" style="width:110px">
					<div id="searchCondDiv">
						<select class="select1" name="searchCond" id="searchCond" onchange="javascript:selectKind(this.value,'');">
								  <%-- <option value="contract" <c:if test="${page.searchCond == 'contract'}">selected</c:if>>계약사별</option> --%>
								  <%-- <option value="plan" <c:if test="${page.searchCond == 'plan'}">selected</c:if>>기획사별</option> --%>
								  <option value="album" <c:if test="${page.searchCond == 'album'}">selected</c:if>>음반별</option>
								  <option value="music" <c:if test="${page.searchCond == 'music'}">selected</c:if>>곡별</option>
								  <option value="artist" <c:if test="${page.searchCond == 'artist'}">selected</c:if>>아티스트별</option>
								  <option value="service" <c:if test="${page.searchCond == 'service'}">selected</c:if>>서비스별</option>
								  <option value="BP" <c:if test="${page.searchCond == 'BP'}">selected</c:if>>BP별</option>
								  <option value="MusicBP" <c:if test="${page.searchCond == 'MusicBP'}">selected</c:if>>곡_BP별</option>
					   </select>
				    </div>
				</div>
				<div class="opt_comm" style="width:110px">
	  				<div id="searchCondDetailDiv">
	  					<select class="select1" style="width:78px" name="searchCondDetail"  id="searchCondDetail" onchange="javascript:selectKindDetail(this.value);">
	                    	<option value="all" selected>전체</option>
						</select>
					</div>
				</div>
				<div class="box_search box_search_block" id="searchKeyWordDiv">
					<label for="" class="screen_out">검색어 입력</label>
					<input type="text" class="tf_search" id="searchKeyWord" name="searchKeyWord" type="text" size="15" value="${page.searchKeyWord}">
					<buttton type="button" class="ico_comm btn_search">검색</button>>
				</div>
				
				
				
				
				<div class="opt_comm" style="width:60px">
					<select class="select1" style="width:51px" name="day_month" id="day_month">
	  							  <option value="day" <c:if test="${page.day_month == 'day' || empty page.day_month}">selected</c:if>>일별</option>
	  				              <option value="month" <c:if test="${page.day_month == 'month'}">selected</c:if>>월별</option>
	  				              </select>
				</div>
				<strong class="tit_filter" style="margin-left:20px">검색기간</strong>
	   			<div class="group_calendar" style="width:300px">
                                  <div class="opt_date">
                                <label for="startDate" class="screen_out">시작날짜 선택상자</label>
                                <input type="text" id="startCalDate" name="startCalDate" class="btn_selected" readonly>
                            </div>

		    <span class="txt_tilde">~</span>
		                              <div class="opt_date">
                                <label for="endDate" class="screen_out">종료날짜 선택상자</label>
                                <input type="text" id="endCalDate" name="endCalDate" class="btn_selected" readonly>
                            </div>
							</div>
				 <button type="submit" class="btn_sm btn_dark" onclick="javascript:goSearch();">검색</button>
				 <button type="button" id="goCondDetail" class="btn_sm"><span class="ico_comm ico_fold"></span>상세검색</button>
			</div>
			
			
			
			
			
			
			<div class="group_flex group_flex_fold">
			
				<c:if test="${downListSize == 1}">
					<input type="hidden" name="downCode" id="downCode" value="${downList[0].pcCode}">
				</c:if>
		      	<c:if test="${downListSize > 1}">
					<strong class="tit_filter" style="margin-left:30px">하위권리사</strong>
					<div class="opt_comm opt_md">
						<strong class="screen_out">하위권리사 선택상자</strong>
						<select class="select1" name="downCode" id="downCode">
					      <option value="all" <c:if test="${page.downCode == ''}">selected</c:if>>전체</option>
					      <c:forEach items="${downList}" var="down">
					      	<c:if test="${empty page.downCodeDe}">
								<option value="${down.pcCode}" <c:if test="${down.pcCode == page.upPcCode}">selected</c:if>>${down.name}</option>
					        </c:if>
					        <c:if test="${not empty page.downCodeDe}">
								<option value="${down.pcCode}" <c:if test="${down.pcCode == page.downCodeDe}">selected</c:if>>${down.name}</option>
					        </c:if>
						  </c:forEach>
				      </select>
					</div>
				</c:if>
			  
				<strong class="tit_filter" style="margin-left:30px">채널</strong>
				<div class="opt_comm" style="width:60px">
					<select class="select1" style="width:60px" name="channelOnOff" onchange="javascript:getChannelList(this[this.selectedIndex].value, false);">
						<option value="all" <c:if test="${page.channelOnOff == 'all'}">selected</c:if>>전체</option>
						<option value="on" <c:if test="${page.channelOnOff == 'on'  || page.channelOnOff == null}">selected</c:if>>ON</option>
						<option value="off" <c:if test="${page.channelOnOff == 'off'}">selected</c:if>>OFF</option>
					</select>
				</div>
				<strong class="tit_filter" style="margin-left:30px">정산유형</strong>
				<div class="opt_comm opt_md">
					<strong class="screen_out">정산유형 선택상자</strong>
					<select class="select1" style="width:105px" name="rightGubun">
						<option value="01" <c:if test="${page.rightGubun == '01'}">selected</c:if>>저작권료</option>
						<option value="02" <c:if test="${page.rightGubun == '02'}">selected</c:if>>실연권료</option>
						<option value="03" <c:if test="${page.rightGubun == '03'|| page.rightGubun == null}">selected</c:if>>저작인접권료</option>
						<option value="04" <c:if test="${page.rightGubun == '04'}">selected</c:if>>정보이용료</option>
					</select>
				</div>
				<strong class="tit_filter" style="margin-left:30px">서비스</strong>
				<div class="opt_comm" style="width:60px">
					<select class="select1" style="width:60px" name="serviceType">
						<option value="group" <c:if test="${page.serviceType == 'group'}">selected</c:if>>그룹</option>
						<option value="detail" <c:if test="${page.serviceType == 'detail'}">selected</c:if>>상세</option>
					</select>
				</div>
				<div class="opt_comm opt_md">
					<div id="serviceTypeDiv" style="display:none;">
				</div>
				<%-- <div class="opt_comm" style="width:60px">
					<select class="select1" style="width:60px" name="viewType">
						<option value="amount" <c:if test="${page.viewType == 'amount'}">selected</c:if>>금액</option>
						<option value="count" <c:if test="${page.viewType == 'count'}">selected</c:if>>건수</option>
					</select>
				</div> --%>
			</div>
			<div class="opt_comm opt_md">
			<div id="serviceDiv"><!-- 초기값 --><input type="hidden" name="serviceCode" value="${page.serviceCode}"><!-- //초기값 --></div>
			<div id="serviceDiv2"><select class="select_log" style="width:140px" disabled><option>전체</option></select></div>
			</div>
		</div>
	</div>			
</fieldset>
</form>
   <!-- <div class="section_comm">
        <div class="container">
            <div class="head_section">
                <h3 class="tit_section">음원 사용 통계</h3>
                <div class="util_section">
                    <div class="group_btn">
                        <button type="button" id="excelBtn" class="btn_sm" style="display:none"><span class="ico_comm ico_excel"></span>엑셀파일
                            예약하기</button>
                    </div>
                    <div class="opt_select">
                        <label for="select" class="screen_out">목록 길이</label>
                        <select id="select">
                            <option value="10">10</option>
                            <option value="25">25</option>
                            <option value="50">50</option>
                            <option value="100">100</option>
                        </select>
                    </div>
                </div>
            </div> -->
<br>
<!--계약사,기획사,곡,음반,아티스트,서비스별 리스트 조회 div  -->
<div id="usageListDiv" class="body_section"> 
	<%-- <c:if test="${page.searchCond == 'MusicBP'}"> >
		<%@ include file="/WEB-INF/view/jsp/LH/musicstat2/usage/usageEmptyPage.jsp"%>
	</c:if> --%>
	<c:if test="${not empty usagelist}">
		<c:choose>
			<c:when test="${page.searchCond == 'album'}">
				<c:if test="${page.level == 'admin'}"> <!--음반별 -->
					<%@ include file="/WEB-INF/view/jsp/LH/musicstat2/usage/usageAlbumList.jsp"%>
				</c:if>
			 	<c:if test="${page.level == 'albumMusic'}"> <!--음반별-곡별 -->
					<%@ include file="/WEB-INF/view/jsp/LH/musicstat2/usage/usageAlbumMusicList.jsp"%>
				</c:if>
		    </c:when>
			<c:when test="${page.searchCond == 'music'}"> <!--곡별 -->
				<c:if test="${page.level == 'admin'}">
					<%@ include file="/WEB-INF/view/jsp/LH/musicstat2/usage/usageMusicList.jsp"%>
				</c:if>
			 	<c:if test="${page.level == 'musicBpService'}">
					<%@ include file="/WEB-INF/view/jsp/LH/musicstat2/usage/usageMusicBpServiceList.jsp"%>
				</c:if>
		    </c:when>
		    <c:when test="${page.searchCond == 'artist'}">
		    	<c:if test="${page.level == 'admin'}"> <!--가수별 -->
					<%@ include file="/WEB-INF/view/jsp/LH/musicstat2/usage/usageArtistList.jsp"%>
				</c:if>
			 	<c:if test="${page.level == 'artistAlbum'}"> <!--가수별-음반별 -->
					<%@ include file="/WEB-INF/view/jsp/LH/musicstat2/usage/usageArtistAlbumList.jsp"%>
				</c:if>
		    </c:when>
		    <c:when test="${page.searchCond == 'service'}"> <!--서비스별  -->
				<c:if test="${page.level == 'admin'}"> <!--서비스별 -->
					<%@ include file="/WEB-INF/view/jsp/LH/musicstat2/usage/usageServiceList.jsp"%>
				</c:if>
			 	<c:if test="${page.level == 'serviceAlbum'}"> <!--서비스별-음반별 -->
					<%@ include file="/WEB-INF/view/jsp/LH/musicstat2/usage/usageArtistAlbumList.jsp"%>
				</c:if>
		    </c:when>
		    <c:when test="${page.searchCond == 'BP'}">
		  	 	<c:if test="${page.level == 'admin'}">  <!-- BP별 -->
					<%@ include file="/WEB-INF/view/jsp/LH/musicstat2/usage/usageBpList.jsp"%>
				</c:if>
			 	<c:if test="${page.level == 'bpAlbum'}">  <!--BP별-음반별  -->
					<%@ include file="/WEB-INF/view/jsp/LH/musicstat2/usage/usageAlbumList.jsp"%>
				</c:if>
				<c:if test="${page.level == 'bpAlbumMusic'}"> <!--BP별-음반별-곡별  -->
					<%@ include file="/WEB-INF/view/jsp/LH/musicstat2/usage/usageMusicList.jsp"%>
				</c:if>
		    </c:when>
		    <c:otherwise>
				<%@ include file="/WEB-INF/view/jsp/LH/musicstat2/usage/usageContractList.jsp"%>
			</c:otherwise>
		</c:choose>
		<br> <%--@ include file="/WEB-INF/view/jsp/Common/statpaginationLH.jsp"--%>
		<div class="dataTables_wrapper">
			<div class="paging_comm">
				<div class="dataTables_paginate">
						<c:if test='${page.prevBlockPage != 0 }'>
						<a href="javascript:gotoPage(${page.prevBlockPage});" class="previous disabled btn_page"><span class="ico_comm">이전</span></a>
						</c:if>
						<c:forEach var="no" begin="${page.pageBegin}" end="${page.pageEnd}">
							<c:choose>
							  <c:when test="${page.pageNo == no}">
								<em class="paginate_button current"><span class="screen_out">선택됨</span><c:out value="${no}" /></em>
							  </c:when>
							  <c:otherwise>
								<a href="javascript:gotoPage(${no})" class="paginate_button"><c:out value="${no}" /></a>
							  </c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${page.nextBlockPage != 0}">
						<a href="javascript:gotoPage(${page.nextBlockPage});" class="last btn_page"><span class="ico_comm">다음</span></a>
						</c:if>
				</div>						
			</div>
		</div>
	</c:if>
</div>


<br>

  <div style="padding-left:30px">
  <table width="965" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td width="665" height="23" align="left">
        <span id="btn_exdn">
        <!-- <img alt="" src="/image/btn_lh11a.gif" onclick="goExcel()"> -->
        <!-- button type="button" class="btn_sm" id="excelUpload" onclick="goExcel()"><span class="ico_comm ico_excel"></span>엑셀파일 다운로드</button -->&nbsp;  <!-- 엑셀파일 다운로드 -->
      	<!-- <img alt="" src="/image/btn_lh12b.gif" onclick="goExcelRes()">&nbsp; -->
      	<button type="button" class="btn_sm" id="excelUpload" onclick="goExcelRes()"><span class="ico_comm ico_excel"></span>엑셀파일 예약하기</button>&nbsp;  <!-- 엑셀파일 다운로드 -->
      	</span>

      	<span id="btn_exdnbm" style="display: none;">
      		<!-- <img alt="" src="/image/btn_lh20a.gif" onclick="goExcelRes()">&nbsp; --><!-- 서비스별 엑셀파일 예약하기 -->
      		<button type="button" class="btn_sm" id="excelUpload" onclick="goExcelRes()"><span class="ico_comm ico_excel"></span>서비스별 엑셀파일 예약하기</button>&nbsp;<!-- 서비스별 엑셀파일 예약하기 -->
      	</span>
      	<span id="btn_exdnsvc" style="display: none;">
      	<c:choose>
		     <c:when test="${page.searchCond=='album' && page.level=='admin'}">
		     	<!-- <img alt="" src="/image/btn_lh20a.gif" onclick="goServiceExcelRes()"> -->
		     	<button type="button" class="btn_sm" id="excelUpload" onclick="goServiceExcelRes()"><span class="ico_comm ico_excel"></span>서비스별 엑셀파일 예약하기</button>
		     </c:when>
		     <c:when test="${page.searchCond=='music' && page.level=='admin'}">
		     	<!-- <img alt="" src="/image/btn_lh20a.gif" onclick="goServiceExcelRes()"> -->
		     	<button type="button" class="btn_sm" id="excelUpload" onclick="goServiceExcelRes()"><span class="ico_comm ico_excel"></span>서비스별 엑셀파일 예약하기</button>
		     </c:when>
		     <c:when test="${page.searchCond=='artist' && page.level=='admin'}">
		     	<!-- <img alt="" src="/image/btn_lh20a.gif" onclick="goServiceExcelRes()"> -->
		     	<button type="button" class="btn_sm" id="excelUpload" onclick="goServiceExcelRes()"><span class="ico_comm ico_excel"></span>서비스별 엑셀파일 예약하기</button>
		     </c:when>
		     <c:when test="${page.searchCond=='artist' && page.level=='artistAlbum'}">
		     	<!-- <img alt="" src="/image/btn_lh20a.gif" onclick="goServiceExcelRes()"> -->
		     	<button type="button" class="btn_sm" id="excelUpload" onclick="goServiceExcelRes()"><span class="ico_comm ico_excel"></span>서비스별 엑셀파일 예약하기</button>
		     </c:when>
		</c:choose>
		</span>
      </td>
    </tr>
  </table>
  </div>
  <br>
</body>
</html>

<!-- ----------------- KONAN : 검색어 자동완성 레이어 선언부 ------------------ -->
<DIV id=AKCDiv style="DISPLAY: none; Z-INDEX: 11; POSITION: absolute;">
	<IFRAME id=AKCIfrm style="WIDTH: 100%; HEIGHT: 3px" name=AKCIfrm marginWidth="0" marginHeight="0" src="${pageContext.request.contextPath}/konan/akc4.html" frameborder="0" scrolling=no>
	</IFRAME>
</DIV>
<IMG alt="" id=AKCArrow style="VISIBILITY: hidden; CURSOR: pointer; POSITION: absolute; left: 563px; top: 18px;" onfocus=this.blur() src="${pageContext.request.contextPath}/konan/images/icokeydown.gif">
<!-- ----------------- KONAN : 검색어 자동완성 레이어 선언부 ------------------ -->