
<!--                this is the details MODAL button thingy!-->
<div class="modal fade" id="detailsModal" tabIndex="-1" role="dialog" aria-labelledby="detailModelLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span class="sr-only">insert x</span></button>
                <h4 class="modal-title" id="detailsModalLabel">Address Details</h4>
            </div>
            <div class="modal-body">
                <h3 class="dange" id="address-id"></h3>
                <table class="table table-bordered">
                    <tr>
                        <th>First Name: </th>
                        <td id="address-firstName"></td>
                    </tr>
                    <tr>
                        <th>Last Name: </th>
                        <td id="address-lastName"></td>
                    </tr>
                    <tr>
                        <th>Street Address: </th>
                        <td id="address-streetAddress"></td>
                    </tr>
                    <tr>
                        <th>City: </th>
                        <td id="address-city"></td>
                    </tr>
                    <tr>
                        <th>State: </th>
                        <td id="address-state"></td>
                    </tr>
                    <tr>
                        <th>Zip Code:</th>
                        <td id="address-zipcode"></td>
                    </tr>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<!--edit modal-->

<div class="modal fade" id="editModal" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="detailsModalLabel">Edit Address</h4>
            </div>
            <div class="modal-body">
                <h3 id="address-id"></h3> 
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="edit=first-name" class="col-md-4 control-label">
                            First Name</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="edit-first-name" placeholder="First Name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit=last-name" class="col-md-4 control-label">
                            Last Name</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="edit-last-name" placeholder="Last Name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit=street-address" class="col-md-4 control-label">
                            Street Address</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="edit-street-address" placeholder="Street Address">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit=city" class="col-md-4 control-label">
                            City</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="edit-city" placeholder="City">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit=state" class="col-md-4 control-label">
                            State</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="edit-state" placeholder="State">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit=zipcode" class="col-md-4 control-label">
                            Zip Code</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="edit-zipcode" placeholder="Zipcode">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <button type="submit" id="edit-button" class="btn btn-default" data-dismiss="modal">Edit Address</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                            <input type="hidden" id="edit-address-id">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
