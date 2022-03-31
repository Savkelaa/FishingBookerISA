import React, { useRef } from "react";
import "../../../src/Assets/css/login.css";

import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";

export default function Login({ logInClientHandler }) {
  const email = useRef();
  const password = useRef();

  console.log("email", email);
  console.log("password", password);

  return (
    <div className="container1">
      <div className="screen">
        <div className="screen__content">
          <form className="login" action="javascript:void(0)">
            <div className="login__field">
              <input
                ref={email}
                type="text"
                className="login__input"
                placeholder="User name / Email"
                id="email"
              />
            </div>
            <div className="login__field">
              <input
                ref={password}
                type="text"
                className="login__input"
                placeholder="Password"
                id="password"
              />
            </div>

            <button
              className="button login__submit"
              onClick={(e) => {
                console.log("email", email.current.value);
                console.log("password", password);
                logInClientHandler(email.current.value, password.current.value);
              }}
            >
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
