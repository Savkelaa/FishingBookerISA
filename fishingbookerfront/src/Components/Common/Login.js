import React, { useRef } from "react";
import "../../../src/Assets/css/login.css";

import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";

export default function Login() {
  return (
    <div className="container1">
      <div className="screen">
        <div className="screen__content">
          <form className="login">
            <div className="login__field">
              <input
                type="text"
                className="login__input"
                placeholder="User name / Email"
              />
            </div>
            <div className="login__field">
              <input
                type="password"
                className="login__input"
                placeholder="Password"
              />
            </div>
            <button className="button login__submit">
              <span className="button__text">Log In </span>
            </button>
            <Link to="userRegistration">
              <button className="button login__submit">
                <span className="button__text">Registration</span>
              </button>
            </Link>
          </form>
          <div className="social-login">
            <h3>Fishing Booker</h3>
            <div className="social-icons"></div>
          </div>
        </div>
        <div className="screen__background">
          <span className="screen__background__shape screen__background__shape4" />
          <span className="screen__background__shape screen__background__shape3" />
          <span className="screen__background__shape screen__background__shape2" />
          <span className="screen__background__shape screen__background__shape1" />
        </div>
      </div>
    </div>
  );
}
