<%@include file="/WEB-INF/view/template/header-index.jsp" %>

<div id="myCarousel" class="carousel slide" data-ride="carousel">

    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img class="first-slide home-image" src="<c:url value="/resources/images/back1.jpg" />" alt="First slide">

            <div class="container">
                <div class="carousel-caption">
                    <h1>Welcome to the Music Store</h1>
                    <p>Here you can browse and buy Instruments, Records and music related Accessories. Order Now for Your Amazing New Kit!</p>

                </div>
            </div>
        </div>
        <div class="item">
            <img class="second-slide home-image" src="<c:url value="/resources/images/back2.jpg" />" alt="Second slide">

            <div class="container">
                <div class="carousel-caption">
                    <h1>Facts You Should Know About Music</h1>
                    <p>Music brings joy, to all of our hearts, It's one of those, emotional arts.</p>
                </div>
            </div>
        </div>
        <div class="item">
            <img class="third-slide home-image" src="<c:url value="/resources/images/back3.jpg" />" alt="Third slide">

            <div class="container">
                <div class="carousel-caption">
                    <h1>It's A Jazz Affair</h1>
                    <p>Through ups and downs, Somehow I manage to survive in life.</p>
                </div>
            </div>
        </div>
    </div>
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>

<div class="container marketing">

    <div class="row">
        <div class="col-lg-4">
            <a class="btn btn-default" href="<c:url value="/product/productList?searchCondition=instrument" />" role="button" >
                <img class="img-circle" src="<c:url value="/resources/images/instrument.jpg" />" width="140" height="140">
            </a>
            <h2>Instument</h2>
            <p>Well crafted and delicate instrument</p>
        </div>

        <div class="col-lg-4">
            <a class="btn btn-default" href="<c:url value="/product/productList?searchCondition=record" />" role="button" >
                <img class="img-circle" src="<c:url value="/resources/images/record.jpg" />" width="140" height="140">
            </a>
            <h2>Discography</h2>
            <p>An exceptional collections of music records in favor of the traditional and modern genre of jazz.</p>
        </div>


        <div class="col-lg-4">
            <a class="btn btn-default" href="<c:url value="/product/productList?searchCondition=accessory" />" role="button" >
                <img class="img-circle" src="<c:url value="/resources/images/accessory.jpg" />" width="140" height="140">
            </a>
            <h2>Accessories</h2>
            <p>All musical and related geeky goods.</p>
        </div>

    </div>

<%@include file="/WEB-INF/view/template/footer.jsp" %>
