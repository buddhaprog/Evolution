
<!--                this is the details MODAL button thingy!-->
<div class="modal fade" id="detailsModal" tabIndex="-1" role="dialog" aria-labelledby="detailModelLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="detailsModalLabel">Bluray Details</h4>
            </div>
            <div class="modal-body">
                <h3 class="danger" id="bluray-id"></h3>
                <table class="table table-bordered">
                    <tr>
                        <th>Title: </th>
                        <td id="bluray-title"></td>
                    </tr>
                    <tr>
                        <th>Release Date: </th>
                        <td id="bluray-release-date"></td>
                    </tr>
                    <tr>
                        <th>MPAA Rating: </th>
                        <td id="bluray-mpaa-rating"></td>
                    </tr>
                    <tr>
                        <th>Director: </th>
                        <td id="bluray-director"></td>
                    </tr>
                    <tr>
                        <th>Studio: </th>
                        <td id="bluray-studio"></td>
                    </tr>
                    <tr>
                        <th>User Rating:</th>
                        <td id="bluray-user-rating"></td>
                    </tr>
                    <tr>
                        <th>User Notes:</th>
                        <td id="bluray-user-notes"></td>
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
                <h4 class="modal-title" id="detailsModalLabel">Edit Bluray</h4>
            </div>
            <div class="modal-body">
                <h3 id="counter-id"></h3> 
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="edit-title" class="col-md-4 control-label">
                            Title: </label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="edit-title" placeholder="Title">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-release-date" class="col-md-4 control-label">
                            Release Date: </label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="edit-release-date" placeholder="Release Date">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-mpaa-rating" class="col-md-4 control-label">
                            MPAA Rating: </label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="edit-mpaa-rating" placeholder="MPAA Rating">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-director" class="col-md-4 control-label">
                            Director: </label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="edit-city" placeholder="Director">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-studio" class="col-md-4 control-label">
                            Studio: </label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="edit-studio" placeholder="Studio">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-user-rating" class="col-md-4 control-label">
                            User Rating: </label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="edit-user-rating" placeholder="User Rating">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-user-notes" class="col-md-4 control-label">
                            User Notes: </label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="edit-user-notes" placeholder="User Notes">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <button type="submit" id="edit-button" class="btn btn-default" data-dismiss="modal">Edit Bluray</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                            <input type="hidden" id="edit-counter-id">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
