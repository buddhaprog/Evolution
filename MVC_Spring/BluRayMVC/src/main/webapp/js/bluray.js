$(document).ready(function () {
    loadBlurays();
    $('#add-button').click(function (event) {
        event.preventDefault();
        $.ajax({
            type: 'POST',
            url: 'bluray',
            data: JSON.stringify({
                title: $('#add-title').val(),
                releaseDate: $('#add-release-date').val(),
                mpaaRating: $('#add-mpaa-rating').val(),
                director: $('#add-director').val(),
                studio: $('#add-studio').val(),
                userRating: $('#add-user-rating').val(),
                userNotes: $('#add-user-notes').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function () {
            $('#add-title').val('');
            $('#add-release-date').val('');
            $('#add-mpaa-rating').val('');
            $('#add-director').val('');
            $('#add-studio').val('');
            $('#add-user-rating').val('');
            $('#add-user-notes').val('');
            loadBlurays();
        });
    });
    $('#edit-button').click(function (event) {
        event.preventDefault();
        $.ajax({
            type: 'PUT',
            url: 'bluray/' + $('#edit-counter-id').val(),
            data: JSON.stringify({
                counterId: $('#edit-counter-id').val(),
                title: $('#edit-title').val(),
                releaseDate: $('#edit-release-date').val(),
                mpaaRating: $('#edit-mpaa-rating').val(),
                director: $('#edit-director').val(),
                studio: $('#edit-studio').val(),
                userRating: $('#edit-user-rating').val(),
                userNotes: $('#edit-user-notes').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function () {
            loadBlurays();
        });
    });
});

function loadBlurays() {
    clearBlurayTable();
    var bTable = $('#contentRows');
    $.ajax({
        url: 'blurays'
    }).success(function (data, status) {
        $.each(data, function (index, bluray) {
            bTable.append($('<tr>')
                    .append($('<td>')
                            .append($('<a>')
                                    .attr({'data-counter-id': bluray.counterId, 'data-toggle': 'modal', 'data-target': '#detailsModal'})
                                    .text(bluray.title + ' ' + bluray.releaseDate)
                                    )
                            )
                    .append($('<td>').text(bluray.director))
                    .append($('<td>')
                            .append($('<a>')
                                    .attr({'data-counter-id': bluray.counterId, 'data-toggle': 'modal', 'data-target': '#editModal'})
                                    .text('Edit')
                                    )
                            )
                    .append($('<td>')
                            .append($('<a>')
                                    .attr({
                                        'onClick': 'deleteBluray(' + bluray.counterId + ')'
                                    })
                                    .text('Delete')
                                    )
                            )
                    );

        });
    });
}

function deleteBluray(id) {
    var answer = confirm("Really Delete?");
    if (answer === true) {
        $.ajax({
            type: 'DELETE',
            url: 'bluray/' + id
        }).success(function () {
            loadBlurays();
        });
    }
}

function clearBlurayTable() {
    $('#contentRows').empty();
}

$('#detailsModal').on('show.bs.modal', function (event) {
    //get the element that triggered the event
    var element = $(event.relatedTarget);
    var counterId = element.data('counter-id');
    //PLACEHOLDER - use dummy data for now
    var modal = $(this); //getting the #detailsModal in orange
    //make an ajax call to get contact information for given contact id
    $.ajax({
        type: "GET",
        url: 'bluray/' + counterId
    }).success(function (bluray) {
        modal.find('#bluray-id').text(bluray.counterId);
        modal.find('#bluray-title').text(bluray.title);
        modal.find('#bluray-release-date').text(bluray.releaseDate);
        modal.find('#bluray-mpaa-rating').text(bluray.mpaaRating);
        modal.find('#bluray-director').text(bluray.director);
        modal.find('#bluray-studio').text(bluray.studio);
        modal.find('#bluray-user-rating').text(bluray.userRating);
        modal.find('#bluray-user-notes').text(bluray.userNotes);
    });
});

//------------------------------------------------------------------------------
//this code runs in response to the show.hs.modal event for the edit modal
$('#editModal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var counterId = element.data('counter-id');
    var modal = $(this);
    $.ajax({
        type: 'GET',
        url: 'bluray/' + counterId
    }).success(function (bluray) {
        modal.find('#counter-id').text(bluray.counterId); 
        modal.find('#edit-counter-id').val(bluray.counterId);
        modal.find('#edit-title').val(bluray.title);
        modal.find('#edit-release-date').val(bluray.releaseDate);
        modal.find('#edit-mpaa-rating').val(bluray.mpaaRating);
        modal.find('#edit-director').val(bluray.director);
        modal.find('#edit-studio').val(bluray.studio);
        modal.find('#edit-user-rating').val(bluray.userRating);
        modal.find('#edit-user-notes').val(bluray.userNotes);
    });
});