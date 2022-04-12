const axios = require("axios");

const userServices = {
  signUpUser: (user) => {
    return axios.post(`${process.env.REACT_APP_API_URL}/signup/async`, user);
  },

  //create new user

  createClient: (client) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL_AUTH}signUpClient`,
      client
    );
  },
  createCottageOwner: (cottageOwner) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL_AUTH}signUpCottageOwner`,
      cottageOwner
    );
  },
  createInstructor: (instrictor) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL_AUTH}signUpInstructor`,
      instrictor
    );
  },
  createBoatOwner: (boatOwner) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL_AUTH}sighUpBoatOwner`,
      boatOwner
    );
  },
  createAdmin: (admin) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL_AUTH}signUpAdmin`,
      admin
    );
  },

  //log in za usere

  logInClient: (email, password) => {
    return axios.post(`${process.env.REACT_APP_API_URL_AUTH}loginClient`, {
      email: email,
      password: password,
    });
  },
  logInCottageOwner: (email, password) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL_AUTH}loginCottageOwner`,
      {
        email: email,
        password: password,
      }
    );
  },
  logInInstructor: (email, password) => {
    return axios.post(`${process.env.REACT_APP_API_URL_AUTH}loginInstructor`, {
      email: email,
      password: password,
    });
  },
  logInBoatOwner: (email, password) => {
    return axios.post(`${process.env.REACT_APP_API_URL_AUTH}loginBoatOwner`, {
      email: email,
      password: password,
    });
  },
  logInAdmin: (email, password) => {
    return axios.post(`${process.env.REACT_APP_API_URL_AUTH}loginAdmin`, {
      email: email,
      password: password,
    });
  },

  //dobijanje svih uloga
  getAllInstructors: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}instructors`);
  },

  getAllCottageOwners: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}cottageOwners`);
  },

  getAllBoatOwners: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}boatOwners`);
  },

  //dobijanje svih rikvestova

  getAllInstructorRequests: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}instructorRequests`);
  },
  getAllCottageOwnerRequests: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}cottageOwnerRequests`);
  },
  getAllBoatOwnerRequests: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}boatOwnerRequests`);
  },

  //odbijanje i prihvatanje zahteva
  activateCottageOwner: (cottageOwner) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}activateCottageOwner/${cottageOwner.id}`
    );
  },
  removeCottageOwner: (cottageOwner) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}removeCottageOwner/${cottageOwner.id}`,
      cottageOwner
    );
  },
  activateBoatOwner: (boatOwner) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}activateBoatOwner/${boatOwner.id}`
    );
  },
  removeBoatOwner: (boatOwner) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}removeBoatOwner/${boatOwner.id}`,
      boatOwner
    );
  },
  activateInstructor: (instructor) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}activateInstructor/${instructor.id}`
    );
  },
  removeInstructor: (instructor) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}removeInstructor/${instructor.id}`,
      instructor
    );
  },

  ///// zahtevi za slanje rikvestova za brisanje
  instructorSendDeleteRequest: (instructor) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}instructorSendDeleteRequest/${instructor.id}`,
      instructor
    );
  },
  cottageOwnerSendDeleteRequest: (cottageOwner) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}cottageOwnerSendDeleteRequest/${cottageOwner.id}`,
      cottageOwner
    );
  },
  boatOwnerSendDeleteRequest: (boatOwner) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}boatOwnerSendDeleteRequest/${boatOwner.id}`,
      boatOwner
    );
  },
  adminSendDeleteRequest: (admin) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}adminSendDeleteRequest/${admin.id}`,
      admin
    );
  },
  clientSendDeleteRequest: (client) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}clientSendDeleteRequest/${client.id}`,
      client
    );
  },

  ///Dobavljanje svih zahteva za brisanje
  getAllInstructorDeleteRequests: () => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}instructorDeleteRequests`
    );
  },
  getAllCottageOwnerDeleteRequests: () => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}cottageOwnerDeleteRequests`
    );
  },
  getAllBoatOwnerDeleteRequests: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}boatOwnerDeleteRequests`);
  },
  getAllAdminDeleteRequests: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}adminDeleteRequests`);
  },
  getAllClientDeleteRequests: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}clientDeleteRequests`);
  },

  //odbijanje zahteva za brisanje
  removeInstructorDeleteRequest: (instructor) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}removeInstructorDeleteRequest/${instructor.id}`,
      instructor
    );
  },
  removeBoatOwnerDeleteRequest: (BoatOwner) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}removeIBoatOwnerDeleteRequest/${BoatOwner.id}`,
      BoatOwner
    );
  },
  removeAdminDeleteRequest: (Admin) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}removeAdminRequest/${Admin.id}`,
      Admin
    );
  },
  removeCottageOwnerDeleteRequest: (CottageOwner) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}removeCottageOwnerRequest/${CottageOwner.id}`,
      CottageOwner
    );
  },
  removeClientDeleteRequest: (Client) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}removeClientDeleteRequest/${Client.id}`,
      Client
    );
  },
};

export default userServices;
