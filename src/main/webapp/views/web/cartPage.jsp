<%@include file="/common/taglib.jsp" %>
<div class="span9">
    <ul class="breadcrumb">
        <li><a href="index.html">Home</a> <span class="divider">/</span></li>
        <li class="active"> SHOPPING CART</li>
    </ul>
    <h3>  SHOPPING CART [ <small>3 Item(s) </small>]<a href="products.html" class="btn btn-large pull-right"><img width="25" height="25" src="https://cdn4.iconfinder.com/data/icons/ionicons/512/icon-ios7-arrow-back-512.png">Continue Shopping </a></h3>
    <hr class="soft"/>
    <table class="table table-bordered">
        <tr><th> I AM ALREADY REGISTERED  </th></tr>
        <tr>
            <td>
                <form class="form-horizontal">
                    <div class="control-group">
                        <label class="control-label" for="inputUsername">Username</label>
                        <div class="controls">
                            <input type="text" id="inputUsername" placeholder="Username">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputPassword1">Password</label>
                        <div class="controls">
                            <input type="password" id="inputPassword1" placeholder="Password">
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">
                            <button type="submit" class="btn">Sign in</button> OR <a href="register.html" class="btn">Register Now!</a>
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">
                            <a href="forgetpass.html" style="text-decoration:underline">Forgot password ?</a>
                        </div>
                    </div>
                </form>
            </td>
        </tr>
    </table>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Product</th>
            <th>Description</th>
            <th>Quantity/Update</th>
            <th>Price</th>
            <th>Discount</th>
            <th>Tax</th>
            <th>Total</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td> <img width="60" src="https://mobileimages.lowes.com/productimages/ddb91624-47c7-4bdb-a476-c753c9316303/04235993.jpg?size=pdhi" alt=""/></td>
            <td>Lethal Axe <br/>Color : black, Material : metal</td>
            <td>
                <div class="input-append">
                    <input class="span1" style="max-width:34px" placeholder="1" id="appendedInputButtons" size="16" type="text">
                    <button class="btn" type="button">-</button>
                    <button class="btn" type="button">+</button>
                    <button class="btn btn-danger" type="button">X</button>
                </div>
            </td>
            <td>$120.00</td>
            <td>$25.00</td>
            <td>$15.00</td>
            <td>$110.00</td>
        </tr>
        <tr>
            <td> <img width="60" src="https://www.gunsamerica.com/blog/wp-content/uploads/2015/09/top-5-purse-guns-glock-42.jpg" alt=""/></td>
            <td>Deathly Glock<br/>Color : black, Material : metal</td>
            <td>
                <div class="input-append">
                    <input class="span1" style="max-width:34px" placeholder="1"  size="16" type="text">
                    <button class="btn" type="button">-</button>
                    <button class="btn" type="button">+</button>
                    <button class="btn btn-danger" type="button">X</button>
                </div>
            </td>
            <td>$7.00</td>
            <td>--</td>
            <td>$1.00</td>
            <td>$8.00</td>
        </tr>

        <tr>
            <td colspan="6" style="text-align:right">Total Price:	</td>
            <td> $228.00</td>
        </tr>
        <tr>
            <td colspan="6" style="text-align:right">Total Discount:	</td>
            <td> $50.00</td>
        </tr>
        <tr>
            <td colspan="6" style="text-align:right">Total Tax:	</td>
            <td> $31.00</td>
        </tr>
        <tr>
            <td colspan="6" style="text-align:right"><strong>TOTAL ($228 - $50 + $31) =</strong></td>
            <td class="label label-important" style="display:block"> <strong> $155.00 </strong></td>
        </tr>
        </tbody>
    </table>

    <a href="products.html" class="btn btn-large"><img width="25" height="25" src="https://cdn4.iconfinder.com/data/icons/ionicons/512/icon-ios7-arrow-back-512.png"> Continue Shopping </a>
    <a href="login.html" class="btn btn-large pull-right">Next <img width="32" height="32" src="https://cdn0.iconfinder.com/data/icons/sharp-edges/24/sharp-icons-arrow-right-512.png"> </a>

</div>
</div></div>
</div>