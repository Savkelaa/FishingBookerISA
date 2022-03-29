import React, { useEffect } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import Login from "../Components/Common/Login";

function LoginContainer() {
  return (
    <div>
      <Navbarr></Navbarr>
      <Login></Login>
      <Footerr></Footerr>
    </div>
  );
}

export default LoginContainer;
