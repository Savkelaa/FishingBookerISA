import { getRoles } from "@testing-library/react";
import React, { useRef } from "react";
import { BrowserRouter as Link } from "react-router-dom";

export default function RegistrationForm({
  addClientHandler,
  addCottageOwnerHandler,
  addInstructorHandler,
  addBoatOwnerHandler,
}) {
  const email = useRef();
  const password = useRef();
  const name = useRef();
  const surname = useRef();
  const address = useRef();
  const city = useRef();
  const country = useRef();
  const explanation = useRef();
  const number = useRef();
  const activated = useRef();
  const role = useRef();

  //console.log("role", role.current.value);

  function saveHandler(e) {
    if (role.current.value == "client") {
      addClientHandler({
        name: name.current.value,
        password: password.current.value,
        email: email.current.value,
        surname: surname.current.value,
        address: address.current.value,
        city: city.current.value,
        country: country.current.value,
        explanation: explanation.current.value,
        number: number.current.value,
        activated: "false",
        deleted: "false",
      });
    } else if (role.current.value == "boatOwner") {
      addBoatOwnerHandler({
        name: name.current.value,
        password: password.current.value,
        email: email.current.value,
        surname: surname.current.value,
        address: address.current.value,
        city: city.current.value,
        country: country.current.value,
        explanation: explanation.current.value,
        number: number.current.value,
        activated: "false",
        deleted: "false",
      });
    } else if (role.current.value == "instructor") {
      addInstructorHandler({
        name: name.current.value,
        password: password.current.value,
        email: email.current.value,
        surname: surname.current.value,
        address: address.current.value,
        city: city.current.value,
        country: country.current.value,
        explanation: explanation.current.value,
        number: number.current.value,
        activated: "false",
        deleted: "false",
      });
    } else if (role.current.value == "cottageOwner") {
      addCottageOwnerHandler({
        name: name.current.value,
        password: password.current.value,
        email: email.current.value,
        surname: surname.current.value,
        address: address.current.value,
        city: city.current.value,
        country: country.current.value,
        explanation: explanation.current.value,
        number: number.current.value,
        activated: "false",
        deleted: "false",
      });
    }
  }

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
                    <h6 for="email">Email address</h6>
                    <input
                      ref={email}
                      type="text"
                      className="form-control"
                      id="start"
                    />
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
                    <h6 for="name">Name</h6>
                    <input
                      ref={name}
                      type="text"
                      className="form-control"
                      id="maxPeople"
                    />
                  </div>
                  <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <h6 for="surname">Surname</h6>
                    <input
                      ref={surname}
                      type="text"
                      className="form-control"
                      id="place"
                    />
                  </div>
                  <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <h6 for="address">Address</h6>
                    <input
                      ref={address}
                      type="text"
                      className="form-control"
                      id="price"
                    />
                  </div>
                  <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <h6 for="city">City</h6>
                    <input
                      ref={city}
                      type="text"
                      className="form-control"
                      id="place"
                    />
                  </div>
                  <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <h6 for="country">Country</h6>
                    <input
                      ref={country}
                      type="text"
                      className="form-control"
                      id="place"
                    />
                  </div>
                  <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <h6 for="number">Number</h6>
                    <input
                      ref={number}
                      type="text"
                      className="form-control"
                      id="place"
                    />
                  </div>
                  <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <h6 for="explanation">Description of Registration</h6>
                    <input
                      ref={explanation}
                      type="text"
                      className="form-control"
                      id="place"
                    />
                  </div>
                  <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <h6 for="website">Type</h6>
                    <select ref={role} id="role" name="role">
                      <option value="cottageOwner">Cottage Owner</option>
                      <option value="instructor">Instrictor</option>
                      <option value="client">Client</option>
                      <option selected value="boatOwner">
                        Boat owner
                      </option>
                    </select>
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
                        Create
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
