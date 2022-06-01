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
      `${process.env.REACT_APP_API_URL_AUTH}signUpBoatOwner`,
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
  getAllClientRequests: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}clientRequests`);
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

  activateClient: (client) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}activateClient/${client.id}`
    );
  },
  removeClient: (client) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}removeClient/${client.id}`,
      client
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

  //// update requests

  updateAdmin: (Admin) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}admins/${Admin.id}`,
      Admin
    );
  },

  updateCottageOwner: (CottageOwner) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}cottageOwners/${CottageOwner.id}`,
      CottageOwner
    );
  },

  updateBoatOwner: (BoatOwner) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}boatOwners/${BoatOwner.id}`,
      BoatOwner
    );
  },

  updateClient: (Client) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}clients/${Client.id}`,
      Client
    );
  },

  updateInstructor: (Instructor) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}instructors/${Instructor.id}`,
      Instructor
    );
  },

  ///// changePasswordAdmin

  changePassword: (Admin) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}changePasswordAdmin/${Admin.id}`,
      Admin
    );
  },

  changePasswordInstructor: (Instructor) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}changePasswordInstructor/${Instructor.id}`,
      Instructor
    );
  },

  changePasswordCottageOwner: (CottageOwner) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}changePasswordCottageOwner/${CottageOwner.id}`,
      CottageOwner
    );
  },

  changePasswordBoatOwner: (BoatOwner) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}changePasswordBoatOwner/${BoatOwner.id}`,
      BoatOwner
    );
  },

  ///// DATE SPANS

  createDateSpan: (dateSpan) => {
    return axios.post(`${process.env.REACT_APP_API_URL}dateSpan`, dateSpan);
  },

  /// DOBAVLJANJE SVIH KLIENTA OD INSTRUKTORA CIJE SU REZERVACIJE ZAVRSENE

  getAllClientsByInstructorFishingClassReservations: (instructorID, name) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}clientsByInstructorFishingClassReservations?instructorId=${instructorID}&name=${name}`
    );
  },

  getAllClientsByInstructorFishingClassQuickReservations: (
    instructorID,
    name
  ) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}clientsByInstructorQuickFishingClassReservations?instructorId=${instructorID}&name=${name}`
    );
  },

  // DOBAVLJANJE KLIJENTA PO IDU

  getClientsById: (clientID) => {
    return axios.get(`${process.env.REACT_APP_API_URL}clients/${clientID}`);
  },

  /// Broj ukupnog broja rezervacija od klienta

  getNumberOfFinishedFishingClassReservations: (clientID) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}numberOfFinishedFishingClassReservations?clientId=${clientID}`
    );
  },

  getNumberOfFinishedFishingClassQuickReservations: (clientID) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}numberOfFinishedFishingClassQuickReservations?clientId=${clientID}`
    );
  },

  getNumberOfFinishedBoatReservations: (clientID) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}numberOfFinishedBoatReservations?clientId=${clientID}`
    );
  },

  getNumberOfFinishedBoatQuickReservations: (clientID) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}numberOfFinishedBoatQuickReservations?clientId=${clientID}`
    );
  },

  getNumberOfFinishedCottageReservations: (clientID) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}numberOfFinishedCottageReservations?clientId=${clientID}`
    );
  },

  getNumberOfFinishedCottageQuickReservations: (clientID) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}numberOfFinishedCottageQuickReservations?clientId=${clientID}`
    );
  },

  ///BROJ UKUPNIH REZERVACIJA ZA SVAKOG OD INSTRUKTORA

  getNumberOfFinishedFishingClassReservationsInstructor: (instructorId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}numberOfFinishedFishingClassReservationsInstructor?instructorId=${instructorId}`
    );
  },

  getNumberOfFinishedFishingClassQuickReservationsInstructor: (
    instructorId
  ) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}numberOfFinishedFishingClassQuickReservationsInstuctor?instructorId=${instructorId}`
    );
  },

  ///BROJ UKUPNIH REZERVACIJA ZA SVAKOG OD BOATOWNERA

  getNumberOfFinishedBoatReservationsBoatOwner: (boatOwnerId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}numberOfFinishedBoatReservationsBoatOwner?boatOwnerId=${boatOwnerId}`
    );
  },

  getNumberOfFinishedBoatQuickReservationsBoatOwner: (boatOwnerId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}numberOfFinishedBoatQuickReservationsBoatOwner?boatOwnerId=${boatOwnerId}`
    );
  },
  ///BROJ UKUPNIH REZERVACIJA ZA SVAKOG OD COTTAGEOWNERA

  getNumberOfFinishedCottageReservationsCottageOwner: (cottageOwner) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}numberOfFinishedCottageReservationsCottageOwner?cottageOwner=${cottageOwner}`
    );
  },

  getNumberOfFinishedCottageQuickReservationsCottageOwner: (cottageOwner) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}numberOfFinishedCottageQuickReservationsCottageOwner?cottageOwner=${cottageOwner}`
    );
  },

  //// poeni nakon zavrsene rezervacije

  getReservationPoints: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}reservationPoints/1`);
  },
  updateReservationPoints: (points) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}reservationPoints/${points.id}`,
      points
    );
  },

  ///KATEGORIJE

  getAllLoyaltyCategories: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}loyaltyCategories`);
  },
  createLoyaltyCategory: (category) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}loyaltyCategories`,
      category
    );
  },

  getLoyaltyCategoryByPoints: (points) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}loyaltyCategoryClient?clientPoints=${points}`
    );
  },
};

export default userServices;
