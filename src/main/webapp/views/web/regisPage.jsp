<%@include file="/common/taglib.jsp" %>
<div class="span9">
    <ul class="breadcrumb">
        <li><a href="index.html">Home</a> <span class="divider">/</span></li>
        <li class="active">Registration</li>
    </ul>
    <h3> Registration</h3>
    <div class="well">
        <form class="form-horizontal" >
            <h4>Your personal information</h4>
            <div class="control-group">
                <label class="control-label">Title <sup>*</sup></label>
                <div class="controls">
                    <select class="span1" name="days">
                        <option value="">-</option>
                        <option value="1">Mr.</option>
                        <option value="2">Mrs</option>
                        <option value="3">Miss</option>
                    </select>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="inputFname1">First name <sup>*</sup></label>
                <div class="controls">
                    <input type="text" id="inputFname1" placeholder="First Name">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="inputLnam">Last name <sup>*</sup></label>
                <div class="controls">
                    <input type="text" id="inputLnam" placeholder="Last Name">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="input_email">Email <sup>*</sup></label>
                <div class="controls">
                    <input type="text" id="input_email" placeholder="Email">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="inputPassword1">Password <sup>*</sup></label>
                <div class="controls">
                    <input type="password" id="inputPassword1" placeholder="Password">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">Date of Birth <sup>*</sup></label>
                    <div class="controls"><input type="date"/></div>
            </div>

            <div class="alert alert-block alert-error fade in">
                <button type="button" class="close" data-dismiss="alert">×</button>
                <strong>Error Block</strong> Customer type script error
            </div>

            <h4>Your address</h4>
            <div class="control-group">
                <label class="control-label" for="address">Address<sup>*</sup></label>
                <div class="controls">
                    <input type="text" id="address" placeholder="Adress"/> <span>Street address, P.O. box, company name, c/o</span>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="city">City<sup>*</sup></label>
                <div class="controls">
                    <input type="text" id="city" placeholder="city"/>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="state">State<sup>*</sup></label>
                <div class="controls">
                    <input type="text" id="state" placeholder="state"/>
                </div>
            </div>


            <div class="control-group">
                <label class="control-label" for="country">Country<sup>*</sup></label>
                <div class="controls">
                        <input type="text" id="country" placeholder="country"/>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="aditionalInfo">Additional information</label>
                <div class="controls">
                    <textarea name="aditionalInfo" id="aditionalInfo" cols="26" rows="3">Additional information</textarea>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="mobile"> Phone Number </label>
                <div class="controls">
                    <input type="text"  name="mobile" id="mobile" placeholder="Phone Number"/>
                </div>
            </div>

            <p><sup>*</sup>Required field	</p>

            <div class="control-group">
                <div class="controls">
                    <input type="hidden" name="email_create" value="1">
                    <input type="hidden" name="is_new_customer" value="1">
                    <input class="btn btn-large btn-success" type="submit" value="Register" />
                </div>
            </div>
        </form>
    </div>

</div>
</div>
</div>
</div>
<!-- MainBody End ============================= -->