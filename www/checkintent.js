module.exports = function(intent, type, successCB) {
    cordova.exec(function(res){
      if (res === "true"){
        successCB(true);
      } else {
        successCB(false);
      }
    }, function(err) {
      console.log("CheckIntent plugin failed");
    }, "CheckIntent", "checkIntent", [intent, type]);
};
