# FROM mcr.microsoft.com/dotnet/core/aspnet:6.0 AS base
# WORKDIR /app
# EXPOSE 80
# EXPOSE 443

# FROM mcr.microsoft.com/dotnet/core/sdk:6.0 AS build
# WORKDIR /src
# COPY ["backend.csproj", ""]
# RUN dotnet restore "./backend.csproj"
# COPY . .
# WORKDIR "/src"
# RUN dotnet build "backend.csproj" -c Release -o /app/build

# FROM mcr.microsoft.com/dotnet/core/sdk:6.0 AS migration
# WORKDIR /src
# COPY . .
# RUN dotnet restore "./backend.csproj"
# COPY . .
# WORKDIR "/src/Migration"
# RUN dotnet build "Migration.csproj" -c Release -o /app/migration

# FROM build AS publish
# RUN dotnet publish "backend.csproj" -c Release -o /app/publish

# FROM base AS final
# WORKDIR /migration
# COPY --from=migration /app/migration .

# WORKDIR /app
# COPY --from=publish /app/publish .
# ENTRYPOINT ["dotnet", "backend.dll"]


FROM mcr.microsoft.com/dotnet/sdk:6.0
WORKDIR /src
COPY ["backend.csproj", ""]
RUN dotnet restore "./backend.csproj"
ENV PATH $PATH:/root/.dotnet/tools
RUN dotnet tool install -g dotnet-ef --version 6.0.1
COPY . .
RUN dotnet dev-certs https --trust
ENTRYPOINT dotnet watch run --urls=http://+:5001 --project backend.csproj