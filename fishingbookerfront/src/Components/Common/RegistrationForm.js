import React, { useRef } from "react";

export default function RegistrationForm() {
  return (
    <div className="container">
      <div className="row gutters">
        <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
          <div className="card h-100">
            <div className="card-body">
              <div className="row gutters">
                <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                  <h5 className="mb-2 text-primary">
                    Create Quick Reservation
                  </h5>
                </div>
                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <h6 for="fullName">Start date</h6>
                  <input type="text" className="form-control" id="start" />
                </div>
                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <h6 for="eMail">The last day </h6>
                  <input type="email" className="form-control" id="last" />
                </div>
                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <h6 for="phone">Maximum number of people</h6>
                  <input type="text" className="form-control" id="maxPeople" />
                </div>
                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <h6 for="website">Place</h6>
                  <input type="url" className="form-control" id="place" />
                </div>
                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <h6 for="website">Price</h6>
                  <input type="url" className="form-control" id="price" />
                </div>
                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <h6 for="website">Additional items</h6>
                  <input type="url" className="form-control" id="place" />
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
