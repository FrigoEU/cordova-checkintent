window.checkIntent = function(str, successCB) {
    cordova.exec(successCB, function(err) {
      console.log("CheckIntent plugin failed");
    }, "CheckIntent", "checkIntent", [str]);
};
