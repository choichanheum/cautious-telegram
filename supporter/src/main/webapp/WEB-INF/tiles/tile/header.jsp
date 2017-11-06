<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


      <header class="header black-bg">
              <div class="sidebar-toggle-box">
                  <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
              </div>
            <!--logo start-->
            <a href="main.do" class="logo"><b>supporter</b></a>
            <!--logo end-->
            
            <div class="top-menu">
            	<ul class="nav pull-right top-menu">
            		<!-- 로그인 안되었을 경우 로그인 버튼 보이게, 로그인 되었을 경우 로그아웃 버튼 보이게 -->
					<c:if test="${sessionScope.id==null }">
	                    <li><a class="logout" href="login.do">Login</a></li>
					</c:if>
					<c:if test="${sessionScope.id!=null }">
	                    <li><a class="logout" href="logout.do">Logout</a></li>
					</c:if>
            	</ul>
            </div>
        </header>