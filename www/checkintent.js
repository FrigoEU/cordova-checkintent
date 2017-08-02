window.checkIntent = function(str, successCB) {
    cordova.exec(function(str){
      if (str === "true"){
        successCB(true);
      } else {
        successCB(false);
      }
    }, function(err) {
      console.log("CheckIntent plugin failed");
    }, "CheckIntent", "checkIntent", [str]);
};
