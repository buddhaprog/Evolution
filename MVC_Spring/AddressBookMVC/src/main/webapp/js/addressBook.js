/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    loadAddresses();

//this is my onclick handler for add button
    $('#add-button').click(function (event) {
        //this next part the prevent default stops the click on the button from submmitting I think
        event.preventDefault();
        $.ajax({
            type: 'POST',
            url: 'address',
            data: JSON.stringify({
                firstName: $('#add-first-name').val(),
                lastName: $('#add-last-name').val(),
                streetAddress: $('#add-street-address').val(),
                city: $('#add-city').val(),
                state: $('#add-state').val(),
                zipcode: $('#add-zipcode').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
                    //the .success part we are going to clear the content so when we add contact the whole section refreshes, this clears then loads it
        }).success(function () {
            $('#add-first-name').val('');
            $('#add-last-name').val('');
            $('#add-street-address').val('');
            $('#add-city').val('');
            $('#add-state').val('');
            $('#add-zipcode').val('');
            loadAddresses();
        });
    });
    //onclick handler for edit button
    $('#edit-button').click(function (event) {
        event.preventDefault();
        //make ajax call
        $.ajax({
            type: 'PUT',
            url: 'address/' + $('#edit-address-id').val(),
            data: JSON.stringify({
                addressId: $('#edit-address-id').val(),
                firstName: $('#edit-first-name').val(),
                lastName: $('#edit-last-name').val(),
                streetAddress: $('#edit-street-address').val(),
                city: $('#edit-city').val(),
                state: $('#edit-state').val(),
                zipcode: $('#edit-zipcode').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function () {
            loadAddresses();
        });
        //decide what to do on success
    });
});
//++++=======+++++
//Functions live here!
//+++========+++++
//load contacts into summary table
function loadAddresses() {

    clearAddressTable();
    var aTable = $('#contentRows');
    $.ajax({
        url: 'addresses'
    }).success(function (data, status) {
        $.each(data, function (index, address) {
            aTable.append($('<tr>')
                    .append($('<td>')
                            .append($('<a>')
                                    .attr({'data-address-id': address.addressId, 'data-toggle': 'modal', 'data-target': '#detailsModal'})
                                    .text(address.firstName + ' ' + address.lastName)
                                    )
                            )
                    .append($('<td>').text(address.streetAddress + ' ' + address.city))
                    .append($('<td>').text(address.state + ' ' + address.zipcode))
                    .append($('<td>')
                            .append($('<a>')
                                    .attr({'data-address-id': address.addressId, 'data-toggle': 'modal', 'data-target': '#editModal'})
                                    .text('Edit')
                                    )
                            )

                    .append($('<td>')
                            .append($('<a>')
                                    .attr({
                                        'onClick': 'deleteAddress(' + address.addressId + ')'
                                    })
                                    .text('Delete')
                                    )
                            )
                    );

        });

    });

}
function deleteAddress(id) {
    var answer = confirm("Really delete?");
    if (answer === true) {
        $.ajax({
            type: 'DELETE',
            url: 'address/' + id
        }).success(function () {
            loadAddresses();
        });
    }
}


function clearAddressTable() {
    $('#contentRows').empty();
}

$('#detailsModal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var addressId = element.data('address-id');
    var modal = $(this);
    $.ajax({
        type: "GET",
        url: 'address/' + addressId
    }).success(function (address) {
        modal.find('#address-id').text(address.addressId);
        modal.find('#address-firstName').text(address.firstName);
        modal.find('#address-lastName').text(address.lastName);
        modal.find('#address-streetAddress').text(address.streetAddress);
        modal.find('#address-city').text(address.city);
        modal.find('#address-state').text(address.state);
        modal.find('#address-zipcode').text(address.zipcode);
    });
});
$('#editModal').on('show.bs.modal', function (event) {
//we have to grat the element that triggers the even
    var element = $(event.relatedTarget);
    var addressId = element.data('address-id');
    var modal = $(this);
    $.ajax({
        type: 'GET',
        url: 'address/' + addressId
    }).success(function (address) {
        modal.find('#address-id').text(address.addressId);
        modal.find('#edit-address-id').val(address.addressId);
        modal.find('#edit-first-name').val(address.firstName);
        modal.find('#edit-last-name').val(address.lastName);
        modal.find('#edit-street-address').val(address.streetAddress);
        modal.find('#edit-city').val(address.city);
        modal.find('#edit-state').val(address.state);
        modal.find('#edit-zipcode').val(address.zipcode);

    });

});
var testAddressData = [
    {
        addressId: 1,
        firstName: "Rob",
        lastName: "Helvey",
        streetAddress: "2402 Woodland avenue",
        city: "South Charleston",
        state: "WV",
        zipcode: "25303"
    },
    {
        addressId: 2,
        firstName: "Stan",
        lastName: "Jones",
        streetAddress: "100 Main Street",
        city: "Columbia",
        state: "SC",
        zipcode: "29201"
    },
    {
        addressId: 3,
        firstName: "Joe",
        lastName: "Smith",
        streetAddress: "200 tank Street",
        city: "Seattle",
        state: "WA",
        zipcode: "55521"
    }

];
var dummyDetailsAddress =
        {
            addressId: 42,
            firstName: "Tom",
            lastName: "Jones",
            streetAddress: "Unusual Way",
            city: "Creepy",
            state: "NY",
            zipcode: "44112"
        };
var dummyEditAddress =
        {
            addressId: 53,
            firstName: "bob",
            lastName: "thorn",
            streetAddress: "200 what in the hell",
            city: "atown",
            state: "VA",
            zipcode: "22180"
        };