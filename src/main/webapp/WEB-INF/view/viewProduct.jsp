<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/view/template/header.jsp" %>

<div class="page-header">
    <h1>Product detail</h1>

    <p class="lead">Here is the detail information about the product!</p>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-5">
            <img src="#" alt="image" style="width: 100%; height: 300px;" />
        </div>
        <div class="col-md-5">
            <h3>${product.productName}</h3>
            <p>${product.productDescription}</p>
            <p>
                <strong>Manufacturer: </strong> ${product.productManufacturer}
            </p>
            <p>
                <strong>Category: </strong>  ${product.productCategory}
            </p>
            <p>
                <strong>Condition: </strong> ${product.productCondition}
            </p>
            <p>
                <strong>Price: </strong> ${product.productPrice}
            </p>
        </div>

    </div>
</div>



<%@ include file="/WEB-INF/view/template/footer.jsp" %>