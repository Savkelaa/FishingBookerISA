import { getRoles } from "@testing-library/react";
import React, { useRef } from "react";
import { BrowserRouter as Link } from "react-router-dom";

export default function ChangePasswordForm({
  logedAdmin,
  changePasswordHandler,
}) {
  const password = useRef();
  const password1 = useRef();

  function saveHandler(e) {
    if (password.current.value != password1.current.value) {
      alert("Enter the same password in both fields");
    } else {
      logedAdmin.password = password.current.value;
      changePasswordHandler(logedAdmin);
    }
  }

  console.log("logedAdmin", logedAdmin);

  return (
    <form action="javascript:void(0);" onSubmit={saveHandler}>
      <div className="container">
        <div className="row gutters">
          <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
            <div className="card h-100">
              <div className="card-body">
                <div className="row gutters">
                  <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <h5 className="mb-2 text-primary">Registration</h5>
                  </div>

                  <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <h6 for="password">Password </h6>
                    <input
                      ref={password}
                      type="password"
                      className="form-control"
                      id="last"
                    />
                  </div>

                  <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <h6 for="password">Confirm Password </h6>
                    <input
                      ref={password1}
                      type="password"
                      className="form-control"
                      id="last"
                    />
                  </div>
                </div>
                <div className="row gutters">
                  <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <div className="text-right">
                      <button
                        type="submit"
                        id="submit"
                        name="submit"
                        className="btn btn-success"
                      >
                        Change Password
                      </button>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </form>
  );
}
