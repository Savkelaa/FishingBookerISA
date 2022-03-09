import React from "react";
import { BrowserRouter as Link } from "react-router-dom";

export default function QuickReservationForm() {
  return (
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
                  <h6 for="fullName">Email address</h6>
                  <input type="text" className="form-control" id="start" />
                </div>
                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <h6 for="eMail">Password </h6>
                  <input type="password" className="form-control" id="last" />
                </div>
                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <h6 for="phone">Name</h6>
                  <input type="text" className="form-control" id="maxPeople" />
                </div>
                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <h6 for="website">Surname</h6>
                  <input type="text" className="form-control" id="place" />
                </div>
                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <h6 for="website">Address</h6>
                  <input type="text" className="form-control" id="price" />
                </div>
                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <h6 for="website">City</h6>
                  <input type="text" className="form-control" id="place" />
                </div>
                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <h6 for="website">Country</h6>
                  <input type="text" className="form-control" id="place" />
                </div>
                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <h6 for="website">Description of Registration</h6>
                  <input type="text" className="form-control" id="place" />
                </div>
                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <h6 for="website">Type</h6>
                  <select id="cars" name="cars">
                    <option value="grapefruit">Cottage Owner</option>
                    <option value="lime">Instrictor</option>
                    <option selected value="coconut">
                      Boat owner
                    </option>
                  </select>
                </div>
              </div>
              <div className="row gutters">
                <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                  <div className="text-right">
                    <button
                      type="button"
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
  );
}
