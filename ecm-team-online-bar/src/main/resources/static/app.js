function getRecommend() {

  $('#resultTable').remove();

  var spiner = '<div id="spiner" class="d-flex justify-content-center mt-5"><div class="spinner-border text-info" role="status"><span class="sr-only">Loading...</span></div></div>'
  $('#overlay').html(spiner);

  $.ajax({
    url: 'http://bar.ecm-team.online/api/v1/recommendations',
    type: 'get',
    dataType: 'json'
  }).done(function(json){
    console.log(json);
    console.log(json.name);
    var text = '<p>' + json.name + '</p><p>' + json.address + '</p><p>' + json.opentime + '</p><p>' + json.tel + '</p>';
    // $('#result').html(text);

    var head = '<table id="resultTable" class="table mt-2"><thead><tr><th>' + json.name + '</th></tr></thead>';
    var address = '<tr><td>' + json.address + '</td></tr>';
    var opentime = '<tr><td>' + json.opentime + '</td></tr>';
    var tel = '<tr><td>' + json.tel + '</td></tr>';
    var tel = '<tr><td><a href="' + json.url + '" target="_blank">店舗URLへ</a></td></tr>';
    var restaurantimg = '<tr><td><img src="' + json.imageurl + '"/></tr></td>';
    var credit = '<tr><td>Supported by <a href="https://api.gnavi.co.jp/api/scope/" target="_blank">ぐるなびWebService</a></tr></td>';
    var body = '<tbody>' + address + opentime + tel + restaurantimg + credit + '</tbody></table>';

    $('#spiner').remove();
    $('#result').html(head + body);

  });
}
