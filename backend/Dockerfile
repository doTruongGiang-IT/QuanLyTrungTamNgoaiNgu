FROM mcr.microsoft.com/dotnet/sdk:6.0
WORKDIR /src
COPY ["backend.csproj", ""]
RUN dotnet restore "./backend.csproj"
ENV PATH $PATH:/root/.dotnet/tools
RUN dotnet tool install -g dotnet-ef --version 6.0.1
COPY . .
RUN dotnet dev-certs https --trust
ENTRYPOINT dotnet watch run --urls=http://+:5001 --project backend.csproj