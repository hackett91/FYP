var WebHDFS = require('webhdfs');
var hdfs = WebHDFS.createClient( {user: 'root',
  host: 'localhost',
  port: 9000,
  path: '/webhdfs/v1'});
var fs = require('fs');

var localFileStream = fs.createReadStream('text.txt');
var remoteFileStream = hdfs.createWriteStream('/home/cian/test-dir/text.txt');

localFileStream.pipe(remoteFileStream);

remoteFileStream.on('error', function onError (err) {
  // Do something with the error
    console.log(err);

});

remoteFileStream.on('finish', function onFinish () {
  // Upload is done
  console.log("good");
});
